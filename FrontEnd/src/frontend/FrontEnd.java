/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Vistas.Principal;
import api.EBS;
import api.EBS_Service;

/**
 *
 * @author Byrich
 */
public class FrontEnd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EBS_Service nws = new EBS_Service();
        EBS service = nws.getEBSPort();
        Principal fend = new Principal();
        fend.servicio = service;
        fend.setVisible(true);
        fend.show();
    }
    
}
