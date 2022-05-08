import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { SavedSale } from '../dtos/sale';
import { SaleItems } from '../dtos/saleItems';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {

  constructor(private service: CustomerService, private sanitizer: DomSanitizer) { }

  public sales : SavedSale[] = [];
  public saleItems : SaleItems[] = [];
  public showProduct : boolean = false;
  public idDetail : number = 0;

  ngOnInit(): void {
    this.service.getSale()
    .subscribe(
      sales => {
        this.sales = sales;
      }
    );

  }

  myFunction(saleId : number) {
    this.idDetail = saleId;
    if(this.showProduct == false){
      this.service.getSaleItems(saleId).subscribe(
        saleItems => {
          this.saleItems = saleItems;
          console.log(this.saleItems);
        }
      );
      this.showProduct = true;
      
    } else {
      this.showProduct = false;
    }
  }
}
