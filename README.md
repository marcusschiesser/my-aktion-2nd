my-aktion
=========

My-Aktion, example application for the german book "[Java EE 7 Workshop](More information at: http://www.dpunkt.de/buecher/4861/workshop-java-ee-7.html)" published by dpunkt.verlag.

Uses Maven 3 ([Download here](http://maven.apache.org/download.cgi)) for building.
This example contains of two different applications my-aktion and my-aktion-monitor which
must be build independently and run on different application servers.


MY-AKTION
---------

The main application allows organizers of nonprofit campaigns (German: Aktion) to create online fundraising forms
for their projects. The organizer can embed these forms into their own website. This allows the
organizer to raise money for his campaign. Each organizer can create forms for multiple campaigns.
The application takes care of the generation of the forms and the management of the campaigns and donations.
This app was tested under WildFly 8.1.0


MY-AKTION-MONITOR
-----------------

The monitor is a simple application that takes heavy usage of new Java EE 7 features 
like WebSocket and REST client. It was tested under Glassfish 4.0. 
It sets up a SOAP and REST based (to demonstrate both technologies) communication with the main app
to retrieve the donations for a selected campaign.


LICENSED UNDER MIT-LICENSE (see LICENSE.md)
