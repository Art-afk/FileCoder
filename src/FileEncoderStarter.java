/**
 * ��������� �� �����������/������������� ������. �� ���� �������� ����� �����. ���� ��� ����������� �����
 * ��������� ������������������ �������� a-z (������ �������). ���� ��� �������������
 * ����� ��������� ������������������ �������� a-z � �����.
 * ��� ������ "�����������" ��������� "���������" ������ ������������������,
 * ������ ��� ������������� ������ ������ �������, � ���������� �� ������, ����������� �� ���������� ����������.
 * ������� ������������������:
 * aaassearsssrmm
 * �������� ������������������:
 * a3s2ears3rm2
 * ��� ������ "�������������" ��������� ��������� �������� ��������.
 * ��� ������ ������ ������ ���� �������� �������
 * ��� ����������� ��������� ���� �� args
 * �� ������ ������ ���� ������� jar ����, ������� ����� ������������ �� ��������� ������
 * <p>
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdCoder.txt
 * C:\Users\Zar\IdeaProjects\FileEncoderApp\Tests\stdDeCoder.txt
 *
 * -debug -decoder //Users//zar//IdeaProjects//FileCoder//Tests//stdCoderOUT.txt //Users//zar//IdeaProjects//FileCoder//Tests//stdDeCoderOUT.txt
 */

public class FileEncoderStarter {
    public static void main(String[] args) throws Exception {

        ConfigBuilder configBuilder = new ConfigBuilder();
        if (args.length != 0) {
            Config config = configBuilder.build(args);
            LogicProcessorApp logic = new LogicProcessorApp(config);
            logic.start();
        } else {
            System.out.println("*Error* Need Args to work");
            System.exit(1);
        }
    }//main
}//class
