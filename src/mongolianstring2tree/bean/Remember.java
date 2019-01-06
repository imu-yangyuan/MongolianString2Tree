/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongolianstring2tree.bean;

/**
 *
 * @author yangy
 */
public class Remember {
    private Long startTime;
    private Long endTime;
    private String MACAddress;
    private String activationCode;
    private String CpuNumber;
    private String saveLastUseFilePath;

    public String getSaveLastUseFilePath() {
        return saveLastUseFilePath;
    }

    public void setSaveLastUseFilePath(String saveLastUseFilePath) {
        this.saveLastUseFilePath = saveLastUseFilePath;
    }
    
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getCpuNumber() {
        return CpuNumber;
    }

    public void setCpuNumber(String CpuNumber) {
        this.CpuNumber = CpuNumber;
    }



   

    @Override
    public String toString() {
        return    " start"+startTime+" end"+endTime+"mac "+MACAddress+"act "+activationCode;
   
    }

   
    
}
