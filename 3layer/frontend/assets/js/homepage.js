

$(document).ready(function () {
    $('#btnGetList').click(async function () {
        console.log("btnGetList clicked");
        const products = await productBUS.getAll();
        console.log("products: ", products);
        const template = `
            <div id={{id}} class="col-12 col-sm-6 col-md-4 col-lg-3 mb-3">
                        <div class="card h-100">
                            <img src="{{thumbnail}}" class="card-img-top"
                                alt="{{name}}">
                            <div class="card-body">
                                <h5 class="card-title">{{name}}</h5>
                                <p class="card-text">Price: {{price}}$</p>
                                <p class="card-text">Description: {{description}}</p>
                            </div>
                        </div>
                    </div>
        `
        const templateScript = Handlebars.compile(template);
        let html = '';
    });

});
