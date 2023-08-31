const { Pool } = require('pg');

const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'shop',
    password: 'localdb',
    port: 5432,
});

class ProductDAO {
    async getAllProducts() {
        const query = 'SELECT * FROM products';
        const { rows } = await pool.query(query);
        return rows;
    }

    async getProductById(id) {
        const query = 'SELECT * FROM products WHERE id=$1';
        const { rows } = await pool.query(query, [id]);
        return rows[0];
    }

    async addProduct(product) {
        const { thumbnail, name, description, price } = user;
        const query = 'INSERT INTO products (thumbnail,name, description, price) VALUES ($1, $2, $3, $4) RETURNING *';
        const { rows } = await pool.query(query, [thumbnail, name, description, price]);
        return rows[0];
    }

    async updateProduct(id, user) {
        const { thumbnail, name, description, price } = user;
        const query = 'UPDATE products SET thumbnail=$1, name=$2, description=$3, price=$4 WHERE id=$5 RETURNING *';
        const { rows } = await pool.query(query, [thumbnail, name, description, price, id]);
        return rows[0];
    }

    async deleteProduct(id) {
        const query = 'DELETE FROM products WHERE id=$1';
        await pool.query(query, [id]);
    }
}

module.exports = { ProductDAO };
