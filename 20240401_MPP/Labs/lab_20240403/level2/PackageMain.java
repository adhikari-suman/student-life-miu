package lab_20240403.level2;

import java.util.*;

public class PackageMain {

    private final static Map<State, Zone> zones;
    private final static List<Carrier> carriers;

    static {
        // Create Zones
        zones = new HashMap<>();
        zones.put(State.OTHERS, new Zone(1, "Others", State.OTHERS));
        zones.put(State.IA, new Zone(2, "IA", State.IA));
        zones.put(State.MT, new Zone(3, "MT", State.MT));
        zones.put(State.OR, new Zone(4, "OR", State.OR));
        zones.put(State.CA, new Zone(5, "CA", State.CA));
        zones.put(State.TX, new Zone(6, "TX", State.TX));
        zones.put(State.UT, new Zone(7, "UT", State.UT));
        zones.put(State.FL, new Zone(8, "FL", State.FL));
        zones.put(State.MA, new Zone(9, "MA", State.MA));
        zones.put(State.OH, new Zone(10, "OH", State.OH));

        // Create carriers
        carriers = new ArrayList<>();

        carriers.add(new FedEx(1, List.of(
                new ZoneRate(zones.get(State.IA), 0.35F),
                new ZoneRate(zones.get(State.MT), 0.35F),
                new ZoneRate(zones.get(State.OR), 0.35F),
                new ZoneRate(zones.get(State.CA), 0.35F),

                new ZoneRate(zones.get(State.TX), 0.30F),
                new ZoneRate(zones.get(State.UT), 0.30F),

                new ZoneRate(zones.get(State.FL), 0.55F),
                new ZoneRate(zones.get(State.MA), 0.55F),
                new ZoneRate(zones.get(State.OH), 0.55F),

                new ZoneRate(zones.get(State.OTHERS), 0.43F)
        )));
        carriers.add(new UPS(2));
        carriers.add(new USMail(3));
        carriers.add(new DHL(4,
                List.of(
                        new ZoneRate(zones.get(State.IA), 0.5F),
                        new ZoneRate(zones.get(State.OTHERS), 0.5F)
                )));
    }

    public static void main(String[] args) {

        Character ch = null;

        do {
            // 1. show menu
            showMenu();

            // 2. Request number of packages
            int packageCount = requestNumberOfPackages();

            // 3. Add all packages
            List<Package> packages = new ArrayList<>();

            for (int i = 0; i < packageCount; i++) {
                packages.add(getPackageDetails(i + 1));
            }

            // 4. calculate pricing for each package
            showLowestPriceFor(packages);

            // Request further action
            ch = requestExit();
        } while (Character.toLowerCase(ch) != 'y');


    }

    public static void showMenu() {
        System.out.println("*** Welcome to Package Manager ***");
    }

    public static Package getPackageDetails(int id) {
        Scanner sc = new Scanner(System.in);

        // Get description
        System.out.printf("\nEnter package description: ");
        String desc = sc.next();

        // Get weight
        System.out.printf("Enter package weight: ");
        double weight = sc.nextDouble();

        // Get Zone
        System.out.printf("Enter state code: ");
        String stateCodeStr = sc.next();

        State state = null;

        for(State st: State.values()){
            if(st.name().equals(stateCodeStr.toUpperCase())){
                state = st;
            }
        }

        if(state == null){
            state = State.OTHERS;
        }


        // Get Sender Type
        SenderType senderType = null;
        System.out.printf("Are you a student? [Y]es or [N]o");
        Character ch = sc.next().charAt(0);

        if(Character.toLowerCase(ch)=='y'){
            senderType = SenderType.STUDENT;
        } else {
            System.out.printf("Enter your age in years? ");

            if(sc.nextInt() >= 65){
                senderType = SenderType.SENIOR_CITIZEN;
            } else {
                senderType = SenderType.OTHERS;
            }
        }



        return new Package(id, desc, weight, zones.get(state), senderType);
    }

    public static int requestNumberOfPackages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many packages");
        return scanner.nextInt();
    }

    public static void showLowestPriceFor(List<Package> packages){
        for (Package p : packages) {
            if (p == null) break;

            Carrier lowestPriceCarrier = null;

            for (Carrier c : carriers) {
                if (c == null) break;


                if (lowestPriceCarrier == null) {
                    lowestPriceCarrier = c;
                } else if (lowestPriceCarrier.getShippingPrice(p) > c.getShippingPrice(p)) {
                    lowestPriceCarrier = c;
                }


            }

            if (lowestPriceCarrier != null) {
                System.out.printf("%-20s $%,-5.2f %-20s\n",
                        p.getDescription(),
                        lowestPriceCarrier.getShippingPrice(p),
                        lowestPriceCarrier.getName());
            }
        }
    }

    public static char requestExit() {
        System.out.printf("Do you want to quit? [Y]es or [N]o: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.next().charAt(0);
    }


}
