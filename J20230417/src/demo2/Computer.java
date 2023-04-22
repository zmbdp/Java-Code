package demo2;

import java.sql.SQLOutput;

public class Computer {
    public void open() {
        System.out.println("打开电脑");
    }
    public void close() {
        System.out.println("关闭电脑");
    }

    public void usbDevice(IUSB usb) {
        usb.openDevice();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;//因为click是子类鼠标里面特有的方法，所以需要强转
            mouse.click();
        }
        else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;//和上同理
            keyBoard.input();
        }
        usb.closeDevice();
    }
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.open();
        IUSB usb[] = {new Mouse(), new KeyBoard()};
        for (IUSB x : usb) {
            computer.usbDevice(x);
        }
        computer.close();
    }
}
