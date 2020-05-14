import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { SideNavBarComponent } from './components/side-nav-bar/side-nav-bar.component';
import { TopNavBarComponent } from './components/top-nav-bar/top-nav-bar.component';
import { ConfigMapperComponent } from './components/config-mapper/config-mapper.component';
import { ResourceSelectorComponent } from './components/resource-selector/resource-selector.component';
import { RequestMapperComponent } from './components/request-mapper/request-mapper.component';
import { ResponseMapperComponent } from './components/response-mapper/response-mapper.component';
import { RequestMethodNavBarComponent } from './components/request-method-nav-bar/request-method-nav-bar.component';
import { RequestMethodMapperComponent } from './components/request-method-mapper/request-method-mapper.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SideNavBarComponent,
    TopNavBarComponent,
    ConfigMapperComponent,
    ResourceSelectorComponent,
    RequestMapperComponent,
    ResponseMapperComponent,
    RequestMethodNavBarComponent,
    RequestMethodMapperComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
