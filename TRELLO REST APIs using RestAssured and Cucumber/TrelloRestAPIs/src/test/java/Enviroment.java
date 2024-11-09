public class Enviroment {

    private static String organization_id;
    private static String board_id;
    private static String list_id;
    private static String key="01dfeb90d4f0c6cfec1578129805caf5";
    private static String token="ATTA44e1b2d281379166376f3b67ba8c966d6f2955da485f8c9f9627ce1014fa75ff48C30D1D";

    public String getOrganization_id(){

        return organization_id;
    }
    public  void setOrganization_id(String neworganization_id){

        organization_id=neworganization_id;
    }

       public String getBoard_id()
       {
        return board_id;
       }

       public void setBoard_id(String newboardId)
       {
           board_id=newboardId;
       }
       public String getList_id()
       {
           return list_id;
       }
       public void setList_id(String newlist_id)
       {
           list_id=newlist_id;
       }
       public String getKey()
       {
           return key;
       }
       public String getToken()
       {
           return token;
       }

}
