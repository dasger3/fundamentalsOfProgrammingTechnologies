//package voronin.view;
//
//import voronin.model.*;
//
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Map;
//
//public class ConsoleView implements View {
//
//    public void ShowATU (AdministrativeTerritorialUnit atu) {
//            Long t_parent_id = 0L;
//            Long t_center_id = 0L;
//            if (atu.getParent() != null) t_parent_id = atu.getParent().getAtuId();
//            if (atu.getCenter_id() != null) t_center_id = atu.getCenter_id().getAtuId();
//
//            System.out.print("\nAdministrativeTerritorialUnit{ ");
//            System.out.printf("atuId=%3s | ",atu.getAtuId());
//            System.out.printf("parent=%3s | ",t_parent_id);
//            System.out.printf("center_id=%3s | ",t_center_id);
//            System.out.printf("typeOfATU=%8s | ",atu.getTypeOfATU());
//            System.out.printf("name=%25s | ",atu.getTitle());
//            System.out.printf("square=%7s | ",atu.getSquare());
//            System.out.printf("population=%7s | ",atu.getSquare());
//            System.out.print("Manager{ ");
//            System.out.printf("managerId=%3s | ",atu.getManager().getManagerId());
//            System.out.printf("name=%10s | ",atu.getManager().getName());
//            System.out.printf("surname=%15s | ",atu.getManager().getSurname());
//            System.out.printf("position=%5s }}",atu.getManager().getPosition());
//
//    }
//    public void ShowATUs (List<AdministrativeTerritorialUnit>ATU) {
//        for (AdministrativeTerritorialUnit atu: ATU) {
//            ShowATU(atu);
//        }
//    }
//
//
//}
