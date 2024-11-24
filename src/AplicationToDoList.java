public class AplicationToDoList {

    public static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static String[] dataMain = new String[10];

    public static void main(String[] args) {





        testInput();

    }



    /**
     * menampilkan to do list
     */

    public static void showDoList() {
        for (int i = 0; i < dataMain.length; i++) {
            String data = dataMain[i];
            int no = i+1 ;

            if (data!=null) {
                System.out.println(no + ". " + data);
            };
        }
    }

    public  static void printDoList() {
        dataMain [0] = "Belajar Java Nih Ges" ;
        dataMain [1] = "Programmer Jangan Lupa Mandi" ;
        showDoList();
    }


    /**
     *
     * menambah to do list
     */

    public  static  void addToDoList(String addData){
        // melihat apakah model penuh ?
        boolean isFull = true;
        for (int i = 0; i < dataMain.length; i++) {
            if (dataMain[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh buat data array menjadi 2 kali lipat
        if (isFull) {
            var temp = dataMain ;
            dataMain = new String[dataMain.length *2 ];

            for (int i = 0; i < dataMain.length; i++) {
                dataMain[i] = temp[i];
            }
        }


        // tambahkan ke posisi ke array nilainya null
        for (int i = 0; i < dataMain.length; i++) {
            if (dataMain[i]==null) {
                dataMain[i] = addData;
                break;
            }
        }
    }

    public static void testAddToDoList(){

            for (int i = 1; i < 10; i++) {
                addToDoList("Add Data At "+i);
            }

        showDoList();
    }


    /**
     * menghapus to do list
     */

    public static boolean removeDoList(Integer number){

        if ((number -1) >= dataMain.length) {
            return false;
        }else if (dataMain[number -1] == null) {
            return false;
        }else {
            for (int i = (number - 1);i <dataMain.length;i++){
                if (i == dataMain.length -1) {
                    dataMain[i] = null;
                } else {
                    dataMain[i] = dataMain[i+1];
                }
            }
            return true;
        }

    }

    public  static void testRemoveFromDoList(){
        addToDoList("uhuy");
        addToDoList("uyas");
        addToDoList("nigger");

        var result = removeDoList(20);
        System.out.println(result);

        result = removeDoList(4);
        System.out.println(result);

        result = removeDoList(2);
        System.out.println(result);

        showDoList();

    }

    public  static String input (String info){
        System.out.print(info+" : ");
        String data = sc.nextLine();
        return data;

    }

    public  static void testInput(){
        String name = input("Nama");
        System.out.println("Hi "+name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * menampilkan view menambahkan to do list
     */

    public static void viewToDoList (){

    }

    /**
     * menampilkan view menghapus to do list
     */

    public static void viewRemoveToDoList (){


    }

}
