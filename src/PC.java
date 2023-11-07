import java.util.Scanner;
public class PC
{
    private float price;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Motherboard mrbrd;
    public PC()
    {
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        mrbrd = new Motherboard();
    }
    public PC(float price) {
        this.price = price;
        cpu = new CPU();
        gpu = new GPU();
        ram = new RAM();
        mrbrd = new Motherboard();
    }
    public PC(float price, CPU cpu, GPU gpu, RAM ram, Motherboard mrbrd) {
        SetPC(price,cpu,gpu,ram,mrbrd);
    }
    private void SetPC(float price, CPU cpu, GPU gpu, RAM ram, Motherboard mrbrd)
    {
        if (price>0)
        {
            this.price = price;
            this.cpu = cpu;
            this.gpu = gpu;
            this.ram = ram;
            this.mrbrd = mrbrd;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public CPU GetCpu() {
        return cpu;
    }
    public GPU GetGpu() {
        return gpu;
    }
    public RAM GetRam() {
        return ram;
    }
    public Motherboard GetMrbrd() {
        return mrbrd;
    }
    public float GetPrice() {
        return price;
    }
    public void input_pc()
    {
        float price;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите стоимость сборки: ");
        price = in.nextFloat();
        cpu.input_CPU();
        gpu.input_GPU();
        ram.input_RAM();
        mrbrd.input_mrbrd();

        SetPC(price,cpu,gpu,ram,mrbrd);
    }
    public void Undervolt_GPU()
    {
        if (gpu.GetTDP() -3 > gpu.GetMin_TDP())
        {
            this.gpu = new GPU(gpu.GetName_gpu(), gpu.GetVram(), gpu.GetTDP() - 3);
            if (gpu.GetTDP()<=gpu.GetMin_TDP())
                gpu = new GPU(gpu.GetName_gpu(), gpu.GetVram(), gpu.GetMin_TDP());
        }
        else
        {
            System.out.print("Undervolt невозможен!");
        }
    }
    public void out_PC()
    {
        System.out.println("\nИнформация о сборке:\n");
        System.out.printf("Процессор: %s, %d МГЦ, %d ядер, %d потоков\n", cpu.GetName(), cpu.GetFrequency(), cpu.GetCores(), cpu.GetTreads());
        System.out.printf("Видеокарта: %s, %d VRAM, %d TDP\n", gpu.GetName_gpu(), gpu.GetVram(), gpu.GetTDP());
        System.out.printf("ОЗУ: %s, %d частота, %d объём\n", ram.GetType_ddr(), ram.GetFrequency(),ram.getMem());
        System.out.printf("Материнская плата: %s, %s чипсет\n", mrbrd.GetName_mrbrd(), mrbrd.GetChipset());
        System.out.printf("Цена сборки: %.2f\n\n",price);
    }
}
