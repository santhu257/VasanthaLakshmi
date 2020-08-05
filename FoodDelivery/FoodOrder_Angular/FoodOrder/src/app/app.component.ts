import {Component,OnInit} from '@angular/core';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'List of Restaurants';
  menuTitle = 'List of Menus';
  showMenus = false;
  showOrderButton = false;
  foodSelected = [];
  foods = [];
  qty = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  constructor(private messageService: MessageService) {
  }
  
  constructor(private http: HttpClient) {

  }
  
  ngOnInit() {
		 foodShops = this.http.get('http://localhost:8080/rest/order/getDetails');
  }

  /*foodShops = [{
    image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
    name: 'Dindigul Thalappakatti',
    rating: 5,
    price: '12',
    status: 'open',
    id: 1

  }, {
    image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
    name: 'Kings Chic',
    rating: 1.2,
    price: '32',
    status: 'open',
    id: 2

  }
    , {
      image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
      name: 'Oyalo',
      rating: 4.3,
      price: '32',
      status: 'open',
      id: 3

    }
    , {
      image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
      name: 'Lassi Shop',
      rating: 3.5,
      price: '32',
      status: 'open',
      id: 4

    }
    , {
      image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
      name: 'Peoples Dosa Kadai',
      rating: 4,
      price: '32',
      status: 'open',
      id: 5

    }, {
      image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
      name: 'Hotel Sri Krishna',
      rating: 2,
      price: '32',
      status: 'closed',
      id: 6

    }, {
      image: 'https://b.zmtcdn.com/webFrontend/64dffaa58ffa55a377cdf42b6a690e721585809275.png',
      name: 'Chennai Kulfi',
      rating: 5,
      price: '32',
      status: 'open',
      id: 7

    }];

  foodsInShop = [{
    image: 'https://b.zmtcdn.com/data/pictures/5/18556495/0d9cde07ea105bedd313eeff65990229_o2_featured_v2.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A',
    name: 'SVP\'s 101 Dosa',
    rating: 5,
    price: '12',
    status: 'open',
    shopId: 1,
    quantity: 1

  }, {
    image: 'https://b.zmtcdn.com/data/pictures/9/68869/43128a4caf1f6c6c00c193014ca089ab_o2_featured_v2.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A',
    name: 'Special Meals',
    rating: 1.2,
    price: '32',
    status: 'open',
    shopId: 2,
    quantity: 1

  }, {
    image: 'https://b.zmtcdn.com/data/pictures/9/68869/43128a4caf1f6c6c00c193014ca089ab_o2_featured_v2.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A',
    name: 'Special Meals1',
    rating: 1.2,
    price: '32',
    status: 'open',
    shopId: 2,
    quantity: 1
  }
  ];*/

  hotelClick(event): void {
    this.foods = this.foodsInShop.filter(res => res.shopId === event.value[0].id);
    this.showMenus = true;
  }

  foodClick(event): void {
    this.showOrderButton = true;
    this.foodSelected = event.value;
  }

  orderClick(): void {
    console.log(this.foodSelected);
  }

  qtyChange(food): void {
    food.multipliedQty = food.price * food.quantity;

  }

  bookOrder(): void {
    const bookJosn = {
      restaurants: this.foodShops.find(res => this.foods[0].shopId).name,
      dishes: this.dishesJson()
    };
    console.log(bookJosn);
  }

  dishesJson(): any {
    const dishes = [];
    this.foodSelected.forEach(res => {
      dishes.push({
        name: res.name,
        price: res.price,
        quantity: res.quantity
      });
    });
    this.messageService.add({severity: 'success', summary: 'Your order has been confirmed', detail: 'Via MessageService'});
    return dishes;
  }
}
