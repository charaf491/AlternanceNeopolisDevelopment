import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent implements OnInit {

  nom = ""
  prenom = ""
  username = ""
  password = ""
  constructor(private sr: ServiceService , private router:Router) { }


  registre() {
    let data: any = {
      "nom": this.nom,
      "prenom": this.prenom,
      "username": this.username,
      "password": this.password
    }
    this.sr.saveUser(data).subscribe(res => { console.log(res) 
      this.router.navigate(['/login'])

    })
  }
  ngOnInit(): void {
  }

}
