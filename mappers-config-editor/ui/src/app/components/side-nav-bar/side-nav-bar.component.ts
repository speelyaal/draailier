import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-nav-bar',
  templateUrl: './side-nav-bar.component.html',
  styleUrls: ['./side-nav-bar.component.scss']
})
export class SideNavBarComponent implements OnInit {

  cloudSources = ["Hetzner", "Linode", "DigitalOcean", "UpCloud", "AWS", "Google Cloud", "Azure", "+ Add"];
  //cloudSources = ["Hetzner", "Linode", "DigitalOcean-big-one-here", "UpCloud", "AWS", "Google Cloud", "Azure", "Hetzner", "Linode", "DigitalOcean-big-one-here", "UpCloud", "AWS", "Google Cloud", "Azure", "+ Add"];

  constructor() { }

  ngOnInit() {
  }

}
