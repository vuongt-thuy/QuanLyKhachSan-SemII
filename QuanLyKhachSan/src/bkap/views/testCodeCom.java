/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views;

import com.sun.xml.internal.bind.v2.ClassFactory;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hongb
 */
public class testCodeCom {
    
    static String generateLicenseKey()
    {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
        CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();
        ComputerSystem computerSystem = hardwareAbstractionLayer.getComputerSystem();

        String vendor = operatingSystem.getManufacturer();
        String processorSerialNumber = computerSystem.getSerialNumber();
        String processorIdentifier = centralProcessor.getIdentifier();
        int processors = centralProcessor.getLogicalProcessorCount();

        String delimiter = "#";

        return vendor +
                delimiter +
                processorSerialNumber +
                delimiter +
                processorIdentifier +
                delimiter +
                processors;
    }

    public static void main(String[] args) {
//        try {
//            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
//            while (nis.hasMoreElements()) {
//                NetworkInterface ni = nis.nextElement();
//                System.out.println(ni.getName() + " " + ni.getDisplayName());
//            }
//        } catch (SocketException ex) {
//            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        ISWbemLocator wbemLocator = ClassFactory.createSWbemLocator();
        
        
        String identifier = generateLicenseKey();
        System.out.println(identifier);
    }

    private static class SystemInfo {

        public SystemInfo() {
        }

        private OperatingSystem getOperatingSystem() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private HardwareAbstractionLayer getHardware() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class OperatingSystem {

        public OperatingSystem() {
        }

        private String getManufacturer() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class HardwareAbstractionLayer {

        public HardwareAbstractionLayer() {
        }

        private CentralProcessor getProcessor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private ComputerSystem getComputerSystem() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class CentralProcessor {

        public CentralProcessor() {
        }

        private String getIdentifier() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private int getLogicalProcessorCount() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class ComputerSystem {

        public ComputerSystem() {
        }

        private String getSerialNumber() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
