package lab_20240403.level1;

import java.util.ArrayList;
import java.util.List;

public class FedEx extends Carrier {

    public final List<ZoneRate> zoneRates;

    public FedEx(int id) {
        super(id, "FedEx");

        zoneRates = new ArrayList<>();
    }

    public FedEx(int id, List<ZoneRate> zoneRates) {
        super(id, "FedEx");
        this.zoneRates = zoneRates;
    }

    public List<ZoneRate> getZoneRates() {
        return zoneRates;
    }

    public void addZoneRate(ZoneRate zoneRate) {
        zoneRates.add(zoneRate);
    }

    public void removeZoneRate(ZoneRate zoneRate) {
        zoneRates.remove(zoneRate);
    }

    @Override
    public double getRate(Package p) {

        ZoneRate zoneRate = null;

        // find the zone-rate per code
        for (ZoneRate rate : zoneRates) {
            if (zoneRate == null && p.getZone().getCode().equals(rate.getZone().getCode())) {
                zoneRate = rate;
            }
        }

        // if code does not match find OTHERS rate and send it back
        if(zoneRate == null){
            for (ZoneRate rate : zoneRates) {
                if (zoneRate == null && rate.getZone().getCode() == State.OTHERS) {
                    zoneRate = rate;
                }
            }
        }

        return zoneRate==null?0:zoneRate.getRate();
    }
}
