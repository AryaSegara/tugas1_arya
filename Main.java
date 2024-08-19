import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner inputanInteger = new Scanner(System.in);
        ArrayList<String> namaMahasiswa = new ArrayList<String>();
        ArrayList<Integer> nilaiMahasiswa = new ArrayList<Integer>();
        int pilihan;
        do{
            System.out.println("Menu : ");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Update Data Mahasiswa");
            System.out.println("3. Delete Data Mahasiswa");
            System.out.println("4. Lihat Semua Data Mahasiswa");
            System.out.println("5. Cari data mahasiswa berdasarkan nama"); 
            System.out.println("6. Keluar dari program");

            System.out.print("Masukkan Pilihan : ");
            pilihan = inputanInteger.nextInt();
            switch(pilihan){
                case 1:
                    tambahDataMahasiswa(namaMahasiswa, nilaiMahasiswa);
                    break;
                case 2:
                    updateDataMahasiswa(namaMahasiswa, nilaiMahasiswa);
                    break;
                case 3:
                    deleteMahsiswa(namaMahasiswa, nilaiMahasiswa);
                    break;
                case 4:
                    lihatSemuaDataMahasiswa(namaMahasiswa, nilaiMahasiswa);
                    break;
                case 5:
                    cariDataMahasiswaByNama(namaMahasiswa,nilaiMahasiswa);
                    break;
                case 6:
                    System.out.println("Keluar Dari Program..");
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia");
            }
        }while(pilihan != 6);


        // inputanInteger.close();
    }

    public static void tambahDataMahasiswa(ArrayList<String> namaMahasiswa, ArrayList<Integer> nilaiMahasiswa){

        Scanner inputanString = new Scanner(System.in);
        Scanner inputanInteger = new Scanner(System.in);

        System.out.print("Masukkan Nama Mahasiswa : ");
        String nama = inputanString.nextLine();
        System.out.print("Masukkan Nilai Mahasiswa : ");
        Integer nilai = inputanInteger.nextInt();

        boolean sudahAda = false;

        for(int i = 0; i < namaMahasiswa.size(); i++){
            if(namaMahasiswa.get(i).equalsIgnoreCase(nama)){
                sudahAda = true;
                break;
            }
        }

        if(sudahAda){
            System.out.println("Mahasiswa Sudah Ada");
        }else{
            namaMahasiswa.add(nama);
            nilaiMahasiswa.add(nilai);
            System.out.println("Data Berhasil Disimpan");
        }


        // inputanInteger.close();
        // inputanString.close();
    }

    public static void updateDataMahasiswa(ArrayList<String> namaMahasiswa, ArrayList<Integer> nilaiMahasiswa){
        Scanner inputStringUpdate = new Scanner(System.in);
        Scanner inputIntegerUpdate = new Scanner(System.in);
        System.out.print("Masukkan Nama mahasiswa yang ingin diupdate : ");
        String nama = inputStringUpdate.nextLine();

        boolean found = false;

        for(int i = 0; i < namaMahasiswa.size(); i++){
            if(namaMahasiswa.get(i).equalsIgnoreCase(nama)){
                System.out.print("Masukkan Nama Baru : ");
                String namaBaru = inputStringUpdate.nextLine();
                System.out.print("Masukkan Nilai Baru :");
                Integer nilaiBaru = inputIntegerUpdate.nextInt();
                
                namaMahasiswa.set(i, namaBaru);
                nilaiMahasiswa.set(i, nilaiBaru);
                
                System.out.println("Nilai Berhasil Diupdate");
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("Mahasiswa Tidak Ditemukan");
        }

        // inputStringUpdate.close();
        // inputIntegerUpdate.close();
    }

    public static void deleteMahsiswa(ArrayList<String> namaMahasiswa, ArrayList<Integer> nilaiMahasiswa){
        Scanner inputNamaDelete = new Scanner(System.in);
        System.out.print("Masukkan Nama mahasiswa yang ingin di hapus : ");
        String nama = inputNamaDelete.nextLine();

        boolean found = false;

            for(int i = 0; i < namaMahasiswa.size(); i++){
                if(namaMahasiswa.get(i).equalsIgnoreCase(nama)){
                    namaMahasiswa.remove(i);
                    nilaiMahasiswa.remove(i);
                    System.out.println("Mahasiswa Berhasil Dihapus");
                    found = true;
                    break;
                }
            }

        if(!found){
            System.out.println("Mahasiswa Tidak Ditemukan");
        }
        


        // inputNamaDelete.close();
    }

    public static void lihatSemuaDataMahasiswa(ArrayList<String> namaMahasiswa, ArrayList<Integer> nilaiMahasiswa){

        if(namaMahasiswa.isEmpty()){
            System.out.println("Data Mahasiswa Kosong");
        }else{
            for(int i = 0; i < nilaiMahasiswa.size(); i++){
                System.out.println("Nama : " + namaMahasiswa.get(i));
                System.out.println("Nilai : " + nilaiMahasiswa.get(i) + " (Grade : " + hitungGrade(nilaiMahasiswa.get(i)) + ")");
                System.out.println();
            }

        }

    }

    public static void cariDataMahasiswaByNama(ArrayList<String> namaMahasiswa, ArrayList<Integer> nilaiMahasiswa){
        // Main main = new Main();
        Scanner inputanString = new Scanner(System.in);
        System.out.print("Masukkan Nama Mahasiswa Yang Ingin Dicari : ");
        String nama = inputanString.nextLine();

        for(int i = 0; i < namaMahasiswa.size(); i++){
            if(namaMahasiswa.get(i).equalsIgnoreCase(nama)){
                System.out.println("Nama : " + namaMahasiswa.get(i));
                System.out.println("Nilai : " + nilaiMahasiswa.get(i) + " (Grade : " + hitungGrade(nilaiMahasiswa.get(i)) + ")");
            }
        }

        // inputanString.close();
    }

    public static String hitungGrade(Integer nilai){
        if(nilai >= 80 && nilai <= 100) return "A";
        else if (nilai >= 70 && nilai <= 79) return "B";
        else if (nilai >= 60 && nilai <= 69) return "C";
        else if (nilai >= 50 && nilai <= 59) return "D";
        else return "E";
    }
        
}



