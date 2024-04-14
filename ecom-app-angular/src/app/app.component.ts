  import {Component, OnInit} from '@angular/core';
  import {KeycloakService} from "keycloak-angular";

  @Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
  })
  export class AppComponent implements OnInit{
    title = 'ecom-app-angular';
    private profile! : KeycloakProfile;
      constructor(public keycloakService : KeycloakService) {
      }
      async handlelogin() {
         await this.keycloakService.login({
           redirectUri : window.location.origin
         });
      }

    handlelogout() {
         this.keycloakService.logout();
    }

    ngOnInit(): void {
        if (this.keycloakService.isLoggedIn()){
          this.keycloakService.loadUserProfile().then(profile=>{
            this.profile = profile
          })
        }
    }
  }
