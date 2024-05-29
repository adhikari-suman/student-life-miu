package lab_20240403.level2;

import java.util.ArrayList;
import java.util.List;

public class DHL extends Carrier {

    public final List<ZoneRate> zoneRates;

    public DHL(int id) {
        super(id, "DHL");

        zoneRates = new ArrayList<>();
    }

    public DHL(int id, List<ZoneRate> zoneRates) {
        super(id, "DHL");
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

        for (ZoneRate rate : zoneRates) {
            if (zoneRate == null && p.getZone().getCode().equals(rate.getZone().getCode())) {
                zoneRate = rate;
            }
        }

        // if code does not match find OTHERS rate and send it back
        if (zoneRate == null) {
            for (ZoneRate rate : zoneRates) {
                if (zoneRate == null && rate.getZone().getCode() == State.OTHERS) {
                    zoneRate = rate;
                }
            }
        }

        return zoneRate == null ? 0 : zoneRate.getRate();
    }
}
