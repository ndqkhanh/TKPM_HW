const { ProductDAO } = require('./js/ProductDAO.js');

class ProductBUS {
    constructor() {
        this.productDAO = new ProductDAO();
    }

    async getAll() {
        return await this.productDAO.getAllProducts();
    }

    async getById(id) {
        return await this.productDAO.getProductById(id);
    }

    async create(product) {
        return await this.productDAO.addProduct(product);
    }

    async update(id, product) {
        return await this.productDAO.updateProduct(id, product);
    }

    async delete(id) {
        return await this.productDAO.deleteProduct(id);
    }
}

module.exports = { ProductBUS };