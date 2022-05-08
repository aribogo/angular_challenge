export interface SaleList {
    id: string;
    quantity: number
}


export class Sale {
    "listOfProducts" : SaleList[] = [];
    "zipCode" : string;

}

export class SavedSale {

    "id" : number;
    "saleDate" : Date;
    "totalAmount": number;
    "zipCode" : string;
    "customerName" : string;
}