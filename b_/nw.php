<?php

class CategoryFetcher
{
    private $connection;

    public function __construct($host, $user, $password, $database)
    {
        $this->connection = new mysqli($host, $user, $password, $database);

        // Check for connection errors
        if ($this->connection->connect_error) {
            die("Connection failed: " . $this->connection->connect_error);
        }
    }

    public function getAllChildren($categoryId)
    {
        return $this->findChildren($categoryId);
    }

    private function findChildren($categoryId)
    {
        $result = [];
        $stmt = $this->connection->prepare("SELECT * FROM categories WHERE parent_id = ?");
        $stmt->bind_param("i", $categoryId);
        $stmt->execute();
        $children = $stmt->get_result();

        while ($child = $children->fetch_assoc()) {
            // Recursively fetch child categories
            $child['children'] = $this->findChildren($child['id']);
            $result[] = $child; // Add the child with its children
        }

        $stmt->close();
        return $result; // Return the structured array
    }

    public function __destruct()
    {
        $this->connection->close();
    }
}

// Usage example
$fetcher = new CategoryFetcher('localhost', 'username', 'password', 'your_database');
$categoryId = 1; // Starting category ID
$children = $fetcher->getAllChildren($categoryId);

print_r($children); // Output the structured result






Array
(
    [0] => Array
        (
            [id] => 1
            [name] => Category 1
            [parent_id] => 
            [children] => Array
                (
                    [0] => Array
                        (
                            [id] => 2
                            [name] => Category 2
                            [parent_id] => 1
                            [children] => Array
                                (
                                    [0] => Array
                                        (
                                            [id] => 4
                                            [name] => Category 4
                                            [parent_id] => 2
                                            [children] => Array
                                                (
                                                )
                                        )
                                )
                        )
                    [1] => Array
                        (
                            [id] => 3
                            [name] => Category 3
                            [parent_id] => 1
                            [children] => Array
                                (
                                )
                        )
                )
        )
)








//sorting

<template>
  <div>
    <table>
      <thead>
        <tr>
          <th @click="sort('name')">Name</th>
          <th @click="sort('age')">Age</th>
          <th @click="sort('city')">City</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in sortedItems" :key="item.id">
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.city }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        { id: 1, name: 'Alice', age: 30, city: 'New York' },
        { id: 2, name: 'Bob', age: 25, city: 'Los Angeles' },
        { id: 3, name: 'Charlie', age: 35, city: 'Chicago' },
      ],
      sortKey: 'name',
      sortOrder: 'asc',
    };
  },
  computed: {
    sortedItems() {
      return this.items.sort((a, b) => {
        const modifier = this.sortOrder === 'asc' ? 1 : -1;
        if (a[this.sortKey] < b[this.sortKey]) return -1 * modifier;
        if (a[this.sortKey] > b[this.sortKey]) return 1 * modifier;
        return 0;
      });
    },
  },
  methods: {
    sort(key) {
      this.sortOrder = this.sortKey === key && this.sortOrder === 'asc' ? 'desc' : 'asc';
      this.sortKey = key;
    },
  },
};
</script>

<style scoped>
th {
  cursor: pointer;
}
</style>




