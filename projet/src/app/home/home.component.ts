import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hide:boolean=false
  ev: any = []
  evid: any = []
  //"Evenement Culturelle", "Evenement Sportifs"
  typseSpc: any = [{ name: "Evenement Culturelle", id: 2 }, { name: "Evenement Sportifs", id: 1 },]
  title = ""
  type = "";
  date = "";
  desc = "";
  photos = "";
  spin: boolean = true;
  ajoutetat: boolean = false;
  constructor(private sr: ServiceService) { }

idU:any=localStorage.getItem('idU');

  ajouter() {
    let data: any = {
      "title": this.title,
      "type": this.type,
      "date": this.date,
      "description": this.desc,
      "photos": this.photos,
      "long": localStorage.getItem('long'),
      "lat": localStorage.getItem('lat')

    }
    this.sr.ajout(data).subscribe(res => {
      console.log(data)
      this.ajoutetat = true;
      this.getEvents()
    })
  }

  getEvents() {
    this.sr.getEvents().subscribe(res => {
      console.log(res)
      this.ev = res
    })
  }
  getById(id: any) {
    this.sr.getEventsbyid(id).subscribe(res => {
      this.evid = res
      console.log(res)
    })
  }
  getPosition(): Observable<any> {
    return Observable.create((observer: { next: (arg0: GeolocationPosition) => void; complete: () => void; error: (arg0: GeolocationPositionError) => void; }) => {
      window.navigator.geolocation.getCurrentPosition(position => {
        observer.next(position);
        observer.complete();
      },
        error => observer.error(error));
    });
  }


  ngOnInit(): void {

    this.getPosition().subscribe(pos => {
      console.log(pos);
      console.log(pos.coords.latitude);
      console.log(pos.coords.longitude);

      localStorage.setItem('long', pos.coords.longitude);
      localStorage.setItem('lat', pos.coords.latitude);
      this.spin = false
    });
    this.getEvents()
console.log(  this.idU)
  }

}
