import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
class Main {

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            System.out.println(gd.getDisplayMode());
        }

        new Main();
    }
    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public class TestPane extends JPanel {

        private CaptureWorker worker;
        private BufferedImage snapshot;

        public TestPane() {
        }

        @Override
        public void addNotify() {
            super.addNotify();
            startCapture();
        }
        Or to easy
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

class Main {

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            System.out.println(gd.getDisplayMode());
        }

        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private CaptureWorker worker;
        private BufferedImage snapshot;

        public TestPane() {
        }

        @Override
        public void addNotify() {
            super.addNotify();
            startCapture();
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            stopCapture();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        protected void startCapture() {
            try {
                stopCapture();
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getScreenDevices()[0];
                worker = new CaptureWorker(gd, new CaptureWorker.Observer() {
                    @Override
                    public void imageAvaliable(CaptureWorker source, BufferedImage img) {
                        TestPane.this.snapshot = img;
                        repaint();
                    }
                });
                worker.execute();
            } catch (AWTException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        protected void stopCapture() {
            if (worker == null) {
                return;
            }
            worker.stop();
            worker = null;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (snapshot != null) {
                double scaleFactor = Math.min(1d, getScaleFactorToFill(new Dimension(snapshot.getWidth(), snapshot.getHeight()), getSize()));
                int scaleWidth = (int) Math.round(snapshot.getWidth() * scaleFactor);
                int scaleHeight = (int) Math.round(snapshot.getHeight() * scaleFactor);

                Image imageToRender = snapshot.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
                int x = (getWidth() - imageToRender.getWidth(this)) / 2;
                int y = (getHeight() - imageToRender.getHeight(this)) / 2;

                g2d.drawImage(imageToRender, x, y, this);
            }
            g2d.dispose();
        }
        public double getScaleFactor(int iMasterSize, int iTargetSize) {
            double dScale = 1;
            dScale = (double) iTargetSize / (double) iMasterSize;

            return dScale;
        }
        public double getScaleFactorToFit(Dimension original, Dimension toFit) {
            double dScale = 1d;

            if (original != null && toFit != null) {
                double dScaleWidth = getScaleFactor(original.width, toFit.width);
                double dScaleHeight = getScaleFactor(original.height, toFit.height);

                dScale = Math.min(dScaleHeight, dScaleWidth);
            }
            return dScale;
        }
        public double getScaleFactorToFill(Dimension masterSize, Dimension targetSize) {
            double dScaleWidth = getScaleFactor(masterSize.width, targetSize.width);
            double dScaleHeight = getScaleFactor(masterSize.height, targetSize.height);

            double dScale = Math.max(dScaleHeight, dScaleWidth);

            return dScale;
        }

    }
    public class CaptureWorker extends SwingWorker<Void, BufferedImage> {

        public interface Observer {

            public void imageAvaliable(CaptureWorker source, BufferedImage img);
        }
        private AtomicBoolean keepRunning = new AtomicBoolean(true);
        private Robot bot;
        private Rectangle captureBounds;

        private final Duration interval = Duration.ofMillis(250);

        private Observer observer;

        public CaptureWorker(GraphicsDevice device, Observer observer) throws AWTException {
            captureBounds = device.getDefaultConfiguration().getBounds();
            this.observer = observer;
            bot = new Robot();
        }

        public void stop() {
            keepRunning.set(false);
        }

        @Override
        protected void process(List<BufferedImage> chunks) {
            BufferedImage img = chunks.get(chunks.size() - 1);
            observer.imageAvaliable(this, img);
        }

        @Override
        protected Void doInBackground() throws Exception {
            try {
                while (keepRunning.get()) {
                    Instant anchor = Instant.now();
                    System.out.println("Snapshot");
                    BufferedImage image = bot.createScreenCapture(captureBounds);
                    System.out.println("Pubish");
                    publish(image);
                    Duration duration = Duration.between(anchor, Instant.now());
                    System.out.println("Took " + duration.toMillis());
                    duration = duration.minus(interval);
                    System.out.println("Time remaining " + duration.toMillis());
                    if (duration.isNegative()) {
                        long sleepTime = Math.abs(duration.toMillis());
                        System.out.println("Sleep for " + sleepTime);
                        Thread.sleep(sleepTime);
                    }
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
            return null;
        }

    }
}

