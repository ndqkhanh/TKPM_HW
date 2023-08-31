import mysql from "mysql";
import Product from "./Product";
require("dotenv").config();

const mysqlConfig = {
  host: process.env.MYSQL_HOST,
  user: process.env.MYSQL_USER,
  password: process.env.MYSQL_PASSWORD,
  database: process.env.MYSQL_DATABASE,
  port: parseInt(process.env.MYSQL_PORT || ""),
};

const pool = mysql.createPool(mysqlConfig);

const getProductById = async (id: string) => {
  console.log(`GET /product/${id}`);
  return new Promise((resolve, reject) => {
    const query = "SELECT * FROM products WHERE id=?";
    pool.query(query, [id], (error, rows) => {
      if (error) {
        reject(error);
      } else {
        resolve(rows);
      }
    });
  });
};

const getListProducts = async () => {
  console.log("GET /product-list");
  return new Promise((resolve, reject) => {
    const query = "SELECT * FROM products";
    pool.query(query, (error, rows) => {
      if (error) {
        reject(error);
      } else {
        resolve(rows);
      }
    });
  });
};

const addProduct = async (product: Product) => {
  console.log("POST /add-product");
  return new Promise((resolve, reject) => {
    const query =
      "INSERT INTO products(thumbnail, name, description, price) VALUES(?, ?, ?, ?)";
    pool.query(
      query,
      [product.thumbnail, product.name, product.description, product.price],
      (error, rows) => {
        if (error) {
          reject(error);
        } else {
          if (rows.affectedRows > 0) {
            resolve(true);
          } else {
            resolve(false);
          }
        }
      }
    );
  });
};

const updateProduct = async (id: string, product: Product) => {
  console.log(`POST /update-product/${id}`);
  return new Promise((resolve, reject) => {
    const query =
      "UPDATE products SET thumbnail=?, name=?, description=?, price=? WHERE id=?";
    pool.query(
      query,
      [product.thumbnail, product.name, product.description, product.price, id],
      (error, rows) => {
        if (error) {
          reject(error);
        } else {
          if (rows.affectedRows > 0) {
            resolve(true);
          } else {
            resolve(false);
          }
        }
      }
    );
  });
};

const deleteProduct = async (id: string) => {
  console.log(`POST /delete-product/${id}`);
  return new Promise((resolve, reject) => {
    const query = "DELETE FROM products WHERE id=?";
    pool.query(query, [id], (error, rows) => {
      if (error) {
        reject(error);
      } else {
        if (rows.affectedRows > 0) {
          resolve(true);
        } else {
          resolve(false);
        }
      }
    });
  });
};

export {
  getProductById,
  getListProducts,
  addProduct,
  updateProduct,
  deleteProduct,
};
