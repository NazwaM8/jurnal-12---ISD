import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Tugas {
    public int prioritas;
    public String Tugas;

    public Tugas(int prioritas, String Tugas) {
        this.prioritas = prioritas;
        this.Tugas = Tugas;
    }

    public String getTugas() {
        return Tugas;
    }
}


class TugasComparator implements Comparator<Tugas> {
    public int compare(Tugas t1, Tugas t2) {
        if (t1.prioritas > t2.prioritas) {
            return 1;
        }
        else if (t1.prioritas < t2.prioritas) {
            return -1;
        }       
        return 0;
    }
}


public class Prioritas {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        PriorityQueue<Tugas> todoList = new PriorityQueue<>(5, new TugasComparator());

        char ch;

        do {
            System.out.println("Daftar Tugas");
            System.out.println("1. Tambah tugas \n2. Tampilkan tugas \n3. Hapus tugas \n4. Hapus semua tugas");
            int choice = userInput.nextInt(); userInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tugas:");
                    String tugas = userInput.nextLine();
                    System.out.print("Masukkan prioritas:");
                    int prioritas = userInput.nextInt();

                    todoList.add(new Tugas(prioritas, tugas));

                    System.out.println("Tugas " + tugas + " berhasil ditambahkan ke list");
                    break;
                case 2:
                    System.out.println("Tugas terdekat yang harus diselesaikan: " + todoList.peek().getTugas());
                    break;
                case 3:
                    System.out.println(todoList.poll().getTugas() + " selesai dilaksanakan, berikutnya " + todoList.peek().getTugas());
                    break;
                case 4:
                    todoList.clear();
                    System.out.println("Semua tugas berhasil dihapus");
                break;
            }

            System.out.println("Lanjut? (y/n)");

            ch = userInput.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }
}
