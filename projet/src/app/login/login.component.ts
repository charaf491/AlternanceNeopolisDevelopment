import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username=""
  password=""
  useRn="";
  passR:any;
userTab:any=[]

id:any=0

constructor(private sr:ServiceService , private router:Router) { }

  getAlluser(){
    this.sr.getUser().subscribe(res => { console.log(res),
    this.userTab=res 
    for (let index = 0; index < this.userTab.length; index++) {
      this.useRn=this.userTab[index]['username'];
      this.passR=this.userTab[index]['password']
    this.id=this.userTab[index]['id']
      
    }
  console.log(this.passR)
  console.log(this.useRn)
if(this.username==this.useRn && this.password == this.passR)
{ 

  localStorage.setItem('idU', this.id);
  this.router.navigate(['/home'])
}

  })
   }

  ngOnInit(): void {
    this.getAlluser()
 
  }

}
