package com.company;

import java.awt.*;

public class Visualization {

   public void VisualizationGold(Graphics g, Gold gold){

       g.drawOval((int)gold.getX(), (int)gold.getY(), gold.getR(), gold.getR());
       g.setColor(Color.YELLOW);
       g.fillOval((int)gold.getX(), (int)gold.getY(), gold.getR(), gold.getR());

   }

   public void VisualizationPirate(Graphics g, Pirate pirate){
       g.drawOval((int)pirate.getX(), (int)pirate.getY(), pirate.getR(), pirate.getR());
       g.setColor(Color.RED);
       g.fillOval((int)pirate.getX(), (int)pirate.getY(), pirate.getR(), pirate.getR());

   }


}
