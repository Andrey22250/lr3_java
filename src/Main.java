// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //пример работы с PC
        PC[] pcList = new PC[2];

        pcList[0] = new PC();
        pcList[0].input_pc();
        System.out.println();
        pcList[1] = new PC();
        pcList[1].input_pc();
        System.out.println();

        pcList[0].out_PC();
        pcList[1].out_PC();
        pcList[0].Undervolt_GPU();
        pcList[0].out_PC();

        //пример работы с Build
        Build BuildEx = new Build("Андрей");
        BuildEx.ChangeStatus(Status.FINISHED);
        BuildEx.out_build();
    }
}