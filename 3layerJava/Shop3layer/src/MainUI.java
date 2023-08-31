import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class ForcedListSelectionModel extends DefaultListSelectionModel {

    public ForcedListSelectionModel() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void clearSelection() {
    }

    @Override
    public void removeSelectionInterval(int index0, int index1) {
    }

}

class EditModal extends JPanel {
    public JTextField idField, oldThumbnailField,
            newThumbnailField,
            oldNameField,
            newNameField,
            oldPriceField,
            newPriceField,
            oldDescriptionField,
            newDescriptionField;

    public EditModal(JTable productTable) {
        setLayout(new BorderLayout());

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints idLabelC = new GridBagConstraints();
        GridBagConstraints idFieldC = new GridBagConstraints();
        GridBagConstraints oldThumbnailLabelC = new GridBagConstraints();
        GridBagConstraints oldThumbnailFieldC = new GridBagConstraints();
        GridBagConstraints newThumbnailLabelC = new GridBagConstraints();
        GridBagConstraints newThumbnailFieldC = new GridBagConstraints();
        GridBagConstraints oldNameLabelC = new GridBagConstraints();
        GridBagConstraints oldNameFieldC = new GridBagConstraints();
        GridBagConstraints newNameLabelC = new GridBagConstraints();
        GridBagConstraints newNameFieldC = new GridBagConstraints();
        GridBagConstraints oldPriceLabelC = new GridBagConstraints();
        GridBagConstraints oldPriceFieldC = new GridBagConstraints();
        GridBagConstraints newPriceLabelC = new GridBagConstraints();
        GridBagConstraints newPriceFieldC = new GridBagConstraints();
        GridBagConstraints oldDescriptionLabelC = new GridBagConstraints();
        GridBagConstraints oldDescriptionFieldC = new GridBagConstraints();
        GridBagConstraints newDescriptionLabelC = new GridBagConstraints();
        GridBagConstraints newDescriptionFieldC = new GridBagConstraints();

        JPanel idLabelPanel = new JPanel();
        JLabel idLabel = new JLabel("Product ID");
        idLabelPanel.add(idLabel);

        JPanel idFieldPanel = new JPanel();
        String id = productTable.getValueAt(productTable.getSelectedRow(), 0).toString();
        idField = new JTextField(id, 30);
        Font newTextFieldFont = new Font(idField.getFont().getName(), idField.getFont().getStyle(), 15);
        idField.setFont(newTextFieldFont);
        idField.setEditable(false);
        idFieldPanel.add(idField);

        JPanel oldThumbnailLabelPanel = new JPanel();
        JLabel oldThumbnailLabel = new JLabel("Old product thumbnail");
        oldThumbnailLabelPanel.add(oldThumbnailLabel);

        JPanel oldThumbnailFieldPanel = new JPanel();
        String old = productTable.getValueAt(productTable.getSelectedRow(), 1).toString();
        oldThumbnailField = new JTextField(old, 30);
        newTextFieldFont = new Font(oldThumbnailField.getFont().getName(), oldThumbnailField.getFont().getStyle(), 15);
        oldThumbnailField.setFont(newTextFieldFont);
        oldThumbnailField.setEditable(false);
        oldThumbnailFieldPanel.add(oldThumbnailField);

        JPanel newThumbnailLabelPanel = new JPanel();
        JLabel newThumbnailLabel = new JLabel("New product thumbnail");
        newThumbnailLabelPanel.add(newThumbnailLabel);

        JPanel newThumbnailFieldPanel = new JPanel();
        newThumbnailField = new JTextField("", 30);
        newTextFieldFont = new Font(newThumbnailField.getFont().getName(), newThumbnailField.getFont().getStyle(), 15);
        newThumbnailField.setFont(newTextFieldFont);
        newThumbnailFieldPanel.add(newThumbnailField);

        JPanel oldNameLabelPanel = new JPanel();
        JLabel oldNameLabel = new JLabel("Old product name");
        oldNameLabelPanel.add(oldNameLabel);

        JPanel oldNameFieldPanel = new JPanel();
        old = productTable.getValueAt(productTable.getSelectedRow(), 2).toString();
        oldNameField = new JTextField(old, 30);
        newTextFieldFont = new Font(oldNameField.getFont().getName(), oldNameField.getFont().getStyle(), 15);
        oldNameField.setFont(newTextFieldFont);
        oldNameField.setEditable(false);
        oldNameFieldPanel.add(oldNameField);

        JPanel newNameLabelPanel = new JPanel();
        JLabel newNameLabel = new JLabel("New product name");
        newNameLabelPanel.add(newNameLabel);

        JPanel newNameFieldPanel = new JPanel();
        newNameField = new JTextField("", 30);
        newTextFieldFont = new Font(newNameField.getFont().getName(), newNameField.getFont().getStyle(), 15);
        newNameField.setFont(newTextFieldFont);
        newNameFieldPanel.add(newNameField);

        JPanel oldPriceLabelPanel = new JPanel();
        JLabel oldPriceLabel = new JLabel("Old product price");
        oldPriceLabelPanel.add(oldPriceLabel);

        JPanel oldPriceFieldPanel = new JPanel();
        old = productTable.getValueAt(productTable.getSelectedRow(), 3).toString();
        oldPriceField = new JTextField(old, 30);
        newTextFieldFont = new Font(oldPriceField.getFont().getName(), oldPriceField.getFont().getStyle(), 15);
        oldPriceField.setFont(newTextFieldFont);
        oldPriceField.setEditable(false);
        oldPriceFieldPanel.add(oldPriceField);

        JPanel newPriceLabelPanel = new JPanel();
        JLabel newPriceLabel = new JLabel("New product price");
        newPriceLabelPanel.add(newPriceLabel);

        JPanel newPriceFieldPanel = new JPanel();
        newPriceField = new JTextField("", 30);
        newTextFieldFont = new Font(newPriceField.getFont().getName(), newPriceField.getFont().getStyle(), 15);
        newPriceField.setFont(newTextFieldFont);
        newPriceFieldPanel.add(newPriceField);

        JPanel oldDescriptionLabelPanel = new JPanel();
        JLabel oldDescriptionLabel = new JLabel("Old product description");
        oldDescriptionLabelPanel.add(oldDescriptionLabel);

        JPanel oldDescriptionFieldPanel = new JPanel();
        old = productTable.getValueAt(productTable.getSelectedRow(), 4).toString();
        oldDescriptionField = new JTextField(old, 30);
        newTextFieldFont = new Font(oldDescriptionField.getFont().getName(), oldDescriptionField.getFont().getStyle(), 15);
        oldDescriptionField.setFont(newTextFieldFont);
        oldDescriptionField.setEditable(false);
        oldDescriptionFieldPanel.add(oldDescriptionField);

        JPanel newDescriptionLabelPanel = new JPanel();
        JLabel newDescriptionLabel = new JLabel("New product description");
        newDescriptionLabelPanel.add(newDescriptionLabel);

        JPanel newDescriptionFieldPanel = new JPanel();
        newDescriptionField = new JTextField("", 30);
        newTextFieldFont = new Font(newDescriptionField.getFont().getName(), newDescriptionField.getFont().getStyle(), 15);
        newDescriptionField.setFont(newTextFieldFont);
        newDescriptionFieldPanel.add(newDescriptionField);

        idLabelC.gridx = 0;
        idLabelC.gridy = 0;
        idLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(idLabelPanel, idLabelC);

        idFieldC.gridx = 1;
        idFieldC.gridy = 0;
        idFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(idFieldPanel, idFieldC);

        oldThumbnailLabelC.gridx = 0;
        oldThumbnailLabelC.gridy = 1;
        oldThumbnailLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(oldThumbnailLabelPanel, oldThumbnailLabelC);

        oldThumbnailFieldC.gridx = 1;
        oldThumbnailFieldC.gridy = 1;
        oldThumbnailFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(oldThumbnailFieldPanel, oldThumbnailFieldC);

        newThumbnailLabelC.gridx = 0;
        newThumbnailLabelC.gridy = 2;
        newThumbnailLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(newThumbnailLabelPanel, newThumbnailLabelC);

        newThumbnailFieldC.gridx = 1;
        newThumbnailFieldC.gridy = 2;
        newThumbnailFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(newThumbnailFieldPanel, newThumbnailFieldC);

        oldNameLabelC.gridx = 0;
        oldNameLabelC.gridy = 3;
        oldNameLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(oldNameLabelPanel, oldNameLabelC);

        oldNameFieldC.gridx = 1;
        oldNameFieldC.gridy = 3;
        oldNameFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(oldNameFieldPanel, oldNameFieldC);

        newNameLabelC.gridx = 0;
        newNameLabelC.gridy = 4;
        newNameLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(newNameLabelPanel, newNameLabelC);

        newNameFieldC.gridx = 1;
        newNameFieldC.gridy = 4;
        newNameFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(newNameFieldPanel, newNameFieldC);

        oldPriceLabelC.gridx = 0;
        oldPriceLabelC.gridy = 5;
        oldPriceLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(oldPriceLabelPanel, oldPriceLabelC);

        oldPriceFieldC.gridx = 1;
        oldPriceFieldC.gridy = 5;
        oldPriceFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(oldPriceFieldPanel, oldPriceFieldC);

        newPriceLabelC.gridx = 0;
        newPriceLabelC.gridy = 6;
        newPriceLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(newPriceLabelPanel, newPriceLabelC);

        newPriceFieldC.gridx = 1;
        newPriceFieldC.gridy = 6;
        newPriceFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(newPriceFieldPanel, newPriceFieldC);

        oldDescriptionLabelC.gridx = 0;
        oldDescriptionLabelC.gridy = 7;
        oldDescriptionLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(oldDescriptionLabelPanel, oldDescriptionLabelC);

        oldDescriptionFieldC.gridx = 1;
        oldDescriptionFieldC.gridy = 7;
        oldDescriptionFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(oldDescriptionFieldPanel, oldDescriptionFieldC);

        newDescriptionLabelC.gridx = 0;
        newDescriptionLabelC.gridy = 8;
        newDescriptionLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(newDescriptionLabelPanel, newDescriptionLabelC);

        newDescriptionFieldC.gridx = 1;
        newDescriptionFieldC.gridy = 8;
        newDescriptionFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(newDescriptionFieldPanel, newDescriptionFieldC);

        add(container, BorderLayout.CENTER);
    }
}

class AddProductModal extends JPanel {
    JTextField thumbnailField, nameField, priceField, descriptionField;

    public AddProductModal() {
        setLayout(new BorderLayout());

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints thumbnailLabelC = new GridBagConstraints();
        GridBagConstraints thumbnailFieldC = new GridBagConstraints();
        GridBagConstraints nameLabelC = new GridBagConstraints();
        GridBagConstraints nameFieldC = new GridBagConstraints();
        GridBagConstraints priceLabelC = new GridBagConstraints();
        GridBagConstraints priceFieldC = new GridBagConstraints();
        GridBagConstraints descriptionLabelC = new GridBagConstraints();
        GridBagConstraints descriptionFieldC = new GridBagConstraints();

        JPanel thumbnailLabelPanel = new JPanel();
        JLabel thumbnailLabel = new JLabel("Input product thumbnail");
        thumbnailLabelPanel.add(thumbnailLabel);

        JPanel thumbnailFieldPanel = new JPanel();
        thumbnailField = new JTextField("", 30);
        Font newTextFieldFont = new Font(thumbnailField.getFont().getName(), thumbnailField.getFont().getStyle(), 15);
        thumbnailField.setFont(newTextFieldFont);
        thumbnailFieldPanel.add(thumbnailField);

        JPanel nameLabelPanel = new JPanel();
        JLabel nameLabel = new JLabel("Input product name");
        nameLabelPanel.add(nameLabel);

        JPanel nameFieldPanel = new JPanel();
        nameField = new JTextField("", 30);
        newTextFieldFont = new Font(nameField.getFont().getName(), nameField.getFont().getStyle(), 15);
        nameField.setFont(newTextFieldFont);
        nameFieldPanel.add(nameField);

        JPanel priceLabelPanel = new JPanel();
        JLabel priceLabel = new JLabel("Input product price");
        priceLabelPanel.add(priceLabel);

        JPanel priceFieldPanel = new JPanel();
        priceField = new JTextField("", 30);
        newTextFieldFont = new Font(priceField.getFont().getName(), priceField.getFont().getStyle(), 15);
        priceField.setFont(newTextFieldFont);
        priceFieldPanel.add(priceField);

        JPanel descriptionLabelPanel = new JPanel();
        JLabel descriptionLabel = new JLabel("Input product description");
        descriptionLabelPanel.add(descriptionLabel);

        JPanel descriptionFieldPanel = new JPanel();
        descriptionField = new JTextField("", 30);
        newTextFieldFont = new Font(descriptionField.getFont().getName(), descriptionField.getFont().getStyle(), 15);
        descriptionField.setFont(newTextFieldFont);
        descriptionFieldPanel.add(descriptionField);

        thumbnailLabelC.weightx = 0.3;
        thumbnailLabelC.gridx = 0;
        thumbnailLabelC.gridy = 0;
        thumbnailLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(thumbnailLabelPanel, thumbnailLabelC);

        thumbnailFieldC.weightx = 0.7;
        thumbnailFieldC.gridx = 1;
        thumbnailFieldC.gridy = 0;
        thumbnailFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(thumbnailFieldPanel, thumbnailFieldC);

        nameLabelC.weightx = 0.3;
        nameLabelC.gridx = 0;
        nameLabelC.gridy = 1;
        nameLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(nameLabelPanel, nameLabelC);

        nameFieldC.weightx = 0.7;
        nameFieldC.gridx = 1;
        nameFieldC.gridy = 1;
        nameFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(nameFieldPanel, nameFieldC);

        priceLabelC.weightx = 0.3;
        priceLabelC.gridx = 0;
        priceLabelC.gridy = 2;
        priceLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(priceLabelPanel, priceLabelC);

        priceFieldC.weightx = 0.7;
        priceFieldC.gridx = 1;
        priceFieldC.gridy = 2;
        priceFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(priceFieldPanel, priceFieldC);

        descriptionLabelC.weightx = 0.3;
        descriptionLabelC.gridx = 0;
        descriptionLabelC.gridy = 3;
        descriptionLabelC.anchor = GridBagConstraints.LINE_START;
        container.add(descriptionLabelPanel, descriptionLabelC);

        descriptionFieldC.weightx = 0.7;
        descriptionFieldC.gridx = 1;
        descriptionFieldC.gridy = 3;
        descriptionFieldC.anchor = GridBagConstraints.LINE_START;
        container.add(descriptionFieldPanel, descriptionFieldC);

        add(container, BorderLayout.CENTER);
    }

    public JTextField getThumbnailField() {
        return thumbnailField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }
}

class MyTableModel extends AbstractTableModel {
    String[] columnNames;
    String[][] data;

    public MyTableModel(String[][] data, String[] columnNames) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public String getValueAt(int row, int col) {
        return data[row][col];
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}

public class MainUI extends JPanel {
    String[] types = {"Id", "Thumbnail", "Name", "Price", "Description"};
    String[] functionNames = {"GET LIST", "ADD", "UPDATE", "DELETE"};
    JButton getListBtn, addBtn, editBtn, delBtn;
    JTable productTable;
    String[][] products;
    AddProductModal addProductModal;
    EditModal editModal;

    public MainUI() {
        setLayout(new BorderLayout());

        JPanel functionButtonsPanel = new JPanel();
        getListBtn = new JButton(functionNames[0]);
        getListBtn.setPreferredSize(new Dimension(100, 40));
        getListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
            }

            public void updateTable() {
                products = Product.convertArrayListToStringArray(ProductBUS.getAll());
                MyTableModel tbModel = new MyTableModel(products, types);
                productTable.setModel(tbModel);
            }
        });

        addBtn = new JButton(functionNames[1]);
        addBtn.setPreferredSize(new Dimension(100, 40));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] temp = new String[]{
                        "Add", "Cancel"
                };
                addProductModal = new AddProductModal();
                int result = JOptionPane.showOptionDialog(null, addProductModal,
                        "ADD PRODUCT", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, temp, temp[0]);
                if (result == JOptionPane.YES_OPTION) {
                    Product newProduct = new Product();
                    String thumbnail = addProductModal.getThumbnailField().getText();
                    boolean flag = thumbnail.equals("");
                    String name = addProductModal.getNameField().getText();
                    if (name.equals("")) {
                        flag = true;
                    }
                    String price = addProductModal.getPriceField().getText();
                    if (price.equals("")) {
                        flag = true;
                    }
                    String description = addProductModal.getDescriptionField().getText();
                    if (description.equals("")) {
                        flag = true;
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Please fill all fields");
                        return;
                    }
                    if (!thumbnail.startsWith("http://") && !thumbnail.startsWith("https://")) {
                        JOptionPane.showMessageDialog(null, "Thumbnail must be a link");
                        return;
                    }
                    try {
                        Float.parseFloat(price);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Price must be a number");
                        return;
                    }
                    newProduct.setThumbnail(thumbnail);
                    newProduct.setName(name);
                    newProduct.setPrice(Float.parseFloat(price));
                    newProduct.setDescription(description);
                    int checkAdd = ProductBUS.add(newProduct);
                    if (checkAdd == 1) {
                        JOptionPane.showMessageDialog(null, "Add product successfully");
                        updateTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Add product failed");
                    }
                }
            }


        });

        editBtn = new JButton(functionNames[2]);
        editBtn.setPreferredSize(new Dimension(100, 40));
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                products = Product.convertArrayListToStringArray(ProductBUS.getAll());
                int row = productTable.getSelectedRow();
                if (row == -1 || row >= products.length) {
                    JOptionPane.showMessageDialog(null, "Please select a product");
                    return;
                }
                String[] temp = new String[]{
                        "Update", "Cancel"
                };
                editModal = new EditModal(productTable);
                int result = JOptionPane.showOptionDialog(null, editModal,
                        "UPDATE PRODUCT", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, temp, temp[0]);
                if (result == JOptionPane.YES_OPTION) {
                    String id = editModal.idField.getText();
                    String thumbnail = editModal.newThumbnailField.getText();
                    String name = editModal.newNameField.getText();
                    String price = editModal.newPriceField.getText();
                    String description = editModal.newDescriptionField.getText();
                    boolean flag = thumbnail.equals("");
                    if (name.equals("")) {
                        flag = true;
                    }
                    if (price.equals("")) {
                        flag = true;
                    }
                    if (description.equals("")) {
                        flag = true;
                    }
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "Please fill all fields");
                        return;
                    }
                    if (!thumbnail.startsWith("http://") && !thumbnail.startsWith("https://")) {
                        JOptionPane.showMessageDialog(null, "Thumbnail must be a link");
                        return;
                    }
                    try {
                        Float.parseFloat(price);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Price must be a number");
                        return;
                    }
                    Product newProduct = new Product();
                    int idProduct = Integer.parseInt(id);
                    newProduct.setId(idProduct);
                    newProduct.setThumbnail(thumbnail);
                    newProduct.setName(name);
                    newProduct.setPrice(Float.parseFloat(price));
                    newProduct.setDescription(description);
                    int checkEdit = ProductBUS.update(idProduct, newProduct);
                    if (checkEdit == 1) {
                        JOptionPane.showMessageDialog(null, "Update product successfully");
                        updateTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Update product failed");
                    }
                }
            }
        });


        delBtn = new JButton(functionNames[3]);
        delBtn.setPreferredSize(new Dimension(100, 40));
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                products = Product.convertArrayListToStringArray(ProductBUS.getAll());
                int row = productTable.getSelectedRow();
                if (row == -1 || row >= products.length) {
                    JOptionPane.showMessageDialog(null, "Please select a product");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                int id = Integer.parseInt(productTable.getValueAt(row, 0).toString());
                int checkDel = ProductBUS.delete(id);
                if (checkDel == 1) {
                    JOptionPane.showMessageDialog(null, "Delete product successfully");
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Delete product failed");
                }
            }
        });

        functionButtonsPanel.add(getListBtn);
        functionButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        functionButtonsPanel.add(addBtn);
        functionButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        functionButtonsPanel.add(editBtn);
        functionButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        functionButtonsPanel.add(delBtn);

        String[][] data = new String[0][0];
        productTable = new JTable(new MyTableModel(data, types));
        productTable.setRowHeight(20);
        productTable.setSelectionModel(new ForcedListSelectionModel());
        productTable.getTableHeader().setReorderingAllowed(false);
        // adding it to JScrollPane
        JScrollPane productSp = new JScrollPane(productTable);

        functionButtonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        add(functionButtonsPanel, BorderLayout.PAGE_START);
        add(productSp, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() throws IOException {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Products List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        MainUI newContentPane = new MainUI();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.setPreferredSize(new Dimension(800, 500));

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void updateTable() {
        products = Product.convertArrayListToStringArray(ProductBUS.getAll());
        MyTableModel tbModel = new MyTableModel(products, types);
        productTable.setModel(tbModel);
    }
}
