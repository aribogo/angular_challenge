import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../services/customer.service';




@Component({
  selector: 'app-register-product',
  templateUrl: './register-product.component.html',
  styleUrls: ['./register-product.component.css']
})
export class RegisterProductComponent implements OnInit {
  public submitted = false;
  public productForm!: FormGroup;
  cardImageBase64: any;
  isImageSaved: boolean = false;
  "base64" : string = "";
  error = "";
  errors = null;
 

  constructor(
    private customerService : CustomerService,
     private fb : FormBuilder,
     ) { }



  ngOnInit(): void {
    this.productForm = this.fb.group({
      name : ['', [Validators.required]],
      description : ['', [Validators.required]],
      measurementUnit :['', [Validators.required]],
      price : [1, [Validators.required]],
      productStock : [1, [Validators.required]],
      base64Image : '',
  
    })
  }


registerProduct(data:any){
  data.base64Image = this.productForm.value.base64Image;
  this.customerService.registerProduct(data)
  .subscribe(result =>{
    this.submitted = true;
    this.productForm.reset();
  },
    err => { 
      this.error = "We could not find save product. Try again later."
      this.errors = err;
    });
    
}

handleFileSelect(evt :any ){
  var files = evt.target.files;
  var file = files[0];

if (files && file) {
    var reader = new FileReader();

    reader.onload =this._handleReaderLoaded.bind(this);

    reader.readAsBinaryString(file);
}
}

_handleReaderLoaded(readerEvt : any) {
 var binaryString = readerEvt.target.result;
        this.base64 = btoa(binaryString);
        this.productForm.controls['base64Image'].setValue(this.base64);

}



 
}
