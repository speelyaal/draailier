import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ConfigMapperComponent } from './components/config-mapper/config-mapper.component';
import { RequestMapperComponent } from './components/request-mapper/request-mapper.component';
import { ResponseMapperComponent } from './components/response-mapper/response-mapper.component';

const routes: Routes = [
  {
    path: "config/:source",
    component: ConfigMapperComponent,
  },
  {
    path: "config",
    component: ConfigMapperComponent,
  },
  {
    path: "request",
    component: RequestMapperComponent,
  },
  {
    path: "response",
    component: ResponseMapperComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class AppRoutingModule {}
