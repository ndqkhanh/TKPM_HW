const express = require('express');
const { create } = require('express-handlebars');
// const { ProductDAO } = require('./ProductDAO/ProductDAO'); // Import ProductDAO class
// const { ProductBUS } = require('./ProductBUS/ProductBUS'); // Import ProductBUS class


const app = express();
const port = 5678;
const path = require('path');
const hbs = create({
  partialsDir: [path.join(__dirname, './views/partials')],
});

// const productDAO = new ProductDAO(); // Create instance of ProductDAO
// const productBUS = new ProductBUS(productDAO); // Create instance of ProductBUS and pass in ProductDAO instance

app.engine('handlebars', hbs.engine);
app.set('view engine', 'handlebars');
app.set('views', path.join(__dirname, './views'));
app.use(express.static(path.join(__dirname, './assets')));
const BACKEND_URL = process.env.BACKEND_URL || 'http://localhost:3000/v1';

app.get('/', (req, res) => {
  res.render('home', {
    title: 'Home',
    BACKEND_URL,
  });
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});
