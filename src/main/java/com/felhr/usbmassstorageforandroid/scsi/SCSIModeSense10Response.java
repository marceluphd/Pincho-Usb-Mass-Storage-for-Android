package com.felhr.usbmassstorageforandroid.scsi;

/**
 * Created by Felipe Herranz(felhr85@gmail.com) on 22/12/14.
 */
public class SCSIModeSense10Response extends SCSIResponse
{
    private int modeDataLength;
    private int mediumType;
    private int deviceSpecificParameter;
    private boolean longLba;
    private int blockDescriptorLength;

    private SCSIModeSense10Response()
    {

    }

    public static SCSIModeSense10Response getResponse(byte[] data)
    {
        SCSIModeSense10Response response = new SCSIModeSense10Response();
        response.modeDataLength = (data[0] << 8) + (data[1]);
        response.mediumType = data[2];
        response.deviceSpecificParameter = data[3];
        response.longLba = (data[4] & 1) == 1;
        response.blockDescriptorLength = (data[6] << 8) + (data[7]);
        return response;
    }

    public int getModeDataLength()
    {
        return modeDataLength;
    }

    public void setModeDataLength(int modeDataLength)
    {
        this.modeDataLength = modeDataLength;
    }

    public int getMediumType()
    {
        return mediumType;
    }

    public void setMediumType(int mediumType)
    {
        this.mediumType = mediumType;
    }

    public int getDeviceSpecificParameter()
    {
        return deviceSpecificParameter;
    }

    public void setDeviceSpecificParameter(int deviceSpecificParameter)
    {
        this.deviceSpecificParameter = deviceSpecificParameter;
    }

    public boolean isLongLba()
    {
        return longLba;
    }

    public void setLongLba(boolean longLba)
    {
        this.longLba = longLba;
    }

    public int getBlockDescriptorLength()
    {
        return blockDescriptorLength;
    }

    public void setBlockDescriptorLength(int blockDescriptorLength)
    {
        this.blockDescriptorLength = blockDescriptorLength;
    }
}
