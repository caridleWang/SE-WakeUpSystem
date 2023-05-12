// 导入一些需要的类
import java.util.Scanner;
import java.util.TimerTask;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
//import java.util.* ;
import java.util.Timer;
//import javax.swing.Timer;

// 定义用户类
class User {
    // 用户属性：生日、情绪、智力、体力
    private LocalDate birthday;
    private double emotion;
    private double intelligence;
    private double physical;

    // 用户构造方法：根据生日计算情绪、智力、体力
    public User(LocalDate birthday) {
        this.birthday = birthday;
        this.emotion = calculateEmotion();
        this.intelligence = calculateIntelligence();
        this.physical = calculatePhysical();
    }

    // 用户方法：获取生日
    public LocalDate getBirthday() {
        return birthday;
    }

    // 用户方法：获取情绪
    public double getEmotion() {
        return emotion;
    }

    // 用户方法：获取智力
    public double getIntelligence() {
        return intelligence;
    }

    // 用户方法：获取体力
    public double getPhysical() {
        return physical;
    }

    // 用户方法：计算情绪，根据生日和当前日期计算情绪周期
    public double calculateEmotion() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        int days = period.getDays();
        double cycle = 23.0; // 情绪周期为23天
        double phase = 2 * Math.PI * days / cycle; // 计算相位角
        return Math.sin(phase); // 返回正弦值作为情绪指数，范围为-1到1
    }

    // 用户方法：计算智力，根据生日和当前日期计算智力周期
    public double calculateIntelligence() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        int days = period.getDays();
        double cycle = 33.0; // 智力周期为33天
        double phase = 2 * Math.PI * days / cycle; // 计算相位角
        return Math.sin(phase); // 返回正弦值作为智力指数，范围为-1到1
    }

    // 用户方法：计算体力，根据生日和当前日期计算体力周期
    public double calculatePhysical() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        int days = period.getDays();
        double cycle = 28.0; // 体力周期为28天
        double phase = 2 * Math.PI * days / cycle; // 计算相位角
        return Math.sin(phase); // 返回正弦值作为体力指数，范围为-1到1
    }
}

// 定义温度调节器类
class TemperatureController {
    // 温度调节器属性：当前温度、目标温度、是否正在调节
    private int currentTemp;
    private int targetTemp;
    private boolean adjusting;

    // 温度调节器构造方法：初始化当前温度为10度，目标温度为20度，是否正在调节为false
    public TemperatureController() {
        this.currentTemp = 10;
        this.targetTemp = 20;
        this.adjusting = false;
    }

    // 温度调节器方法：获取当前温度
    public int getCurrentTemp() {
        return currentTemp;
    }

    // 温度调节器方法：获取目标温
        // 温度调节器方法：获取目标温度
    public int getTargetTemp() {
        return targetTemp;
    }

    // 温度调节器方法：设置目标温度
    public void setTargetTemp(int targetTemp) {
        this.targetTemp = targetTemp;
    }

    // 温度调节器方法：获取是否正在调节
    public boolean isAdjusting() {
        return adjusting;
    }

    // 温度调节器方法：开始调节温度
    public void startAdjusting() {
        this.adjusting = true;
        // 创建一个定时器，每隔10秒执行一次任务
        //Timer timer = new Timer(currentTemp, null);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // 如果当前温度小于目标温度，就增加1度
                if (currentTemp < targetTemp) {
                    currentTemp++;
                    System.out.println("当前温度：" + currentTemp + "°");
                }
                // 如果当前温度等于目标温度，就停止调节并取消定时器
                else if (currentTemp == targetTemp) {
                    adjusting = false;
                    System.out.println("温度调节完成");
                    timer.cancel();
                    //task.cancel();
                }
            }
        };
        timer.schedule(task, 0, 10000); // 定时器从0秒开始，每隔10秒执行一次任务
        
    }
        // 温度调节器方法：停止调节温度
    public void stopAdjusting() {
        this.adjusting = false;
    }

    // 温度调节器方法：增加当前温度
    public void increaseCurrentTemp() {
        this.currentTemp++;
    }
}

// 定义光线调节器类
class LightController {
    // 光线调节器属性：当前光线、目标光线、是否正在调节
    private int currentLight;
    private int targetLight;
    private boolean adjusting;

    // 光线调节器构造方法：初始化当前光线为3级，目标光线为10级，是否正在调节为false
    public LightController() {
        this.currentLight = 3;
        this.targetLight = 10;
        this.adjusting = false;
    }

    // 光线调节器方法：获取当前光线
    public int getCurrentLight() {
        return currentLight;
    }

    // 光线调节器方法：获取目标光线
    public int getTargetLight() {
        return targetLight;
    }

    // 光线调节器方法：获取是否正在调节
    public boolean isAdjusting() {
        return adjusting;
    }

        // 光线调节器方法：设置目标光线
    public void setTargetLight(int targetLight) {
        this.targetLight = targetLight;
    }

    // // 光线调节器方法：开始调节光线
    // public void startAdjusting() {
    //     this.adjusting = true;
    // }

    // 光线调节器方法：停止调节光线
    public void stopAdjusting() {
        this.adjusting = false;
    }

    // 光线调节器方法：增加当前光线
    public void increaseCurrentLight() {
        this.currentLight++;
    }

    // 光线调节器方法：开始调节光线
    public void startAdjusting() {
        this.adjusting = true;
        // 创建一个定时器，每隔30秒执行一次任务
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // 如果当前光线小于目标光线，就增加1级
                if (currentLight < targetLight) {
                    currentLight++;
                    System.out.println("当前光线：" + currentLight + "级");
                }
                // 如果当前光线等于目标光线，就停止调节并取消定时器
                else if (currentLight == targetLight) {
                    adjusting = false;
                    System.out.println("光线调节完成");
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 0, 30000); // 定时器从0秒开始，每隔30秒执行一次任务
    }
}

// // 定义智能音箱类
// class SmartSpeaker {
//     // 智能音箱属性：音乐列表、播放状态、播放索引
//     private String[] musicList;
//     private boolean playing;
//     private int index;

//     // 智能音箱构造方法：初始化音乐列表为任意四首歌曲，播放状态为false，播放索引为0
//     public SmartSpeaker() {
//         this.musicList = new String[] {"Let It Go", "Shape of You", "Bad Guy", "Despacito"};
//         this.playing = false;
//         this.index = 0;
//     }

    // // 温度调节器方法：获取目标温度
    // public int getTargetTemp() {
    //     return targetTemp;
    // }

    // // 温度调节器方法：获取是否正在调节
    // public boolean isAdjusting() {
    //     return adjusting;
    // }

    // // 温度调节器方法：设置目标温度
    // public void setTargetTemp(int targetTemp) {
    //     this.targetTemp = targetTemp;
    // }

    // // 温度调节器方法：开始调节温度
    // public void startAdjusting() {
    //     this.adjusting = true;
    // }

    // // 温度调节器方法：停止调节温度
    // public void stopAdjusting() {
    //     this.adjusting = false;
    // }

    // // 温度调节器方法：增加当前温度
    // public void increaseCurrentTemp() {
    //     this.currentTemp++;
    // }
//}

// // 定义光线调节器类
// class LightController {
//     // 光线调节器属性：当前光线、目标光线、是否正在调节
//     private int currentLight;
//     private int targetLight;
//     private boolean adjusting;

//     // 光线调节器构造方法：初始化当前光线为1级，目标光线为3级，是否正在调节为false
//     public LightController() {
//         this.currentLight = 1;
//         this.targetLight = 3;
//         this.adjusting = false;
//     }

//     // 光线调节器方法：获取当前光线
//     public int getCurrentLight() {
//         return currentLight;
//     }

//     // 光线调节器方法：获取目标光线
//     public int getTargetLight() {
//         return targetLight;
//     }

//     // 光线调节器方法：获取是否正在调节
//     public boolean isAdjusting() {
//         return adjusting;
//     }

//     // 光线调节器方法：设置目标光线
//     public void setTargetLight(int targetLight) {
//         this.targetLight = targetLight;
//     }

//     // 光线调节器方法：开始调节光线
//     public void startAdjusting() {
//         this.adjusting = true;
//     }

//     // 光线调节器方法：停止调节光线
//     public void stopAdjusting() {
//         this.adjusting = false;
//     }

//     // 光线调节器方法：增加当前光线
//     public void increaseCurrentLight() {
//         this.currentLight++;
//     }
// }

// 定义智能音箱类
class SmartSpeaker {
    // 智能音箱属性：播放的音乐、是否正在播放
    private String music;
    private boolean playing;

    // 智能音箱构造方法：初始化播放的音乐为null，是否正在播放为false
    public SmartSpeaker() {
        this.music = null;
        this.playing = false;
    }

    // 智能音箱方法：获取播放的音乐
    public String getMusic() {
        return music;
    }

    // 智能音箱方法：获取是否正在播放
    public boolean isPlaying() {
        return playing;
    }

    // 智能音箱方法：设置播放的音乐
    public void setMusic(String music) {
        this.music = music;
    }

    // 智能音箱方法：开始播放音乐
    public void startPlaying() {
        this.playing = true;
    }

    // 智能音箱方法：停止播放音乐
    public void stopPlaying() {
        this.playing = false;
    }
}

// 定义按摩床类
class MassageBed {
    // 按摩床属性：当前按摩力度、是否正在按摩
    private int currentStrength;
    private boolean massaging;

    // 按摩床构造方法：初始化当前按摩力度为0，是否正在按摩为false
    public MassageBed() {
        this.currentStrength = 0;
        this.massaging = false;
    }

    // 按摩床方法：获取当前按摩力度
    public int getCurrentStrength() {
        return currentStrength;
    }

    // 按摩床方法：获取是否正在按摩
    public boolean isMassaging() {
        return massaging;
    }

    // 按摩床方法：开始按摩
    public void startMassaging() {
        this.massaging = true;
        this.currentStrength = 1; // 开始按摩时，设置当前按摩力度为1
    }

    // 按摩床方法：停止按摩
    public void stopMassaging() {
        this.massaging = false;
        this.currentStrength = 0; // 停止按摩时，设置当前按摩力度为0
    }

    // 按摩床方法：增加当前按摩力度
    public void increaseCurrentStrength() {
        this.currentStrength++;
    }
}

// 定义起床系统类
class WakeUpSystem {
    // 起床系统属性：用户、起床时间、温度调节器、光线调节器、智能音箱、按摩床
    private User user;
    private LocalTime wakeUpTime;
    private TemperatureController tempController;
    private LightController lightController;
    private SmartSpeaker speaker;
    private MassageBed bed;

    private JLabel countdownLabel;
    private JLabel  adjustingLabel; 
    private JLabel adjustingLightLabel; 
    private JLabel currentLightLabel;
    private JLabel playingLabel;
    private JLabel massagingLabel;
    private JLabel currentStrengthLabel;
    private JLabel currentTempLabel;

    // 起床系统构造方法：初始化各个属性
    public WakeUpSystem() {
        this.user = null;
        this.wakeUpTime = LocalTime.of(7, 0, 0); // 默认起床时间为7:00:00
        this.tempController = new TemperatureController();
        this.lightController = new LightController();
        this.speaker = new SmartSpeaker();
        this.bed = new MassageBed();
    }

    // 起床系统方法：获取用户
    public User getUser() {
        return user;
    }

    // 起床系统方法：获取起床时间
    public LocalTime getWakeUpTime() {
        return wakeUpTime;
    }

    // 起床系统方法：获取温度调节器
    public TemperatureController getTempController() {
        return tempController;
    }

    // 起床系统方法：获取光线调节器
    public LightController getLightController() {
        return lightController;
    }

    // 起床系统方法：获取智能音箱
    public SmartSpeaker getSpeaker() {
        return speaker;
    }

    // 起床系统方法：获取按摩床
    public MassageBed getBed() {
        return bed;
    }

    // 起床系统方法：设置用户，根据用户输入的生日创建用户对象
    public void setUser(String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday); // 将字符串转换为LocalDate对象
        this.user = new User(birthDate); // 创建用户对象
        adjustWakeUpTime(); // 根据用户的情绪调整起床时间
    }

    // 起床系统方法：设置起床时间，根据用户输入的时间创建LocalTime对象
    public void setWakeUpTime(String time) {
        this.wakeUpTime = LocalTime.parse(time); // 将字符串转换为LocalTime对象
    }

    // 起床系统方法：根据用户的情绪调整起床时间，如果情绪低于均值，则延长10分钟
    public void adjustWakeUpTime() {
        if (user != null && user.getEmotion() < 0) { // 检查用户是否存在且情绪是否低于均值
            this.wakeUpTime = this.wakeUpTime.plusMinutes(10); // 增加10分钟
        }
    }

    // 起床系统方法：判断是否到达起床时间，如果到达，则启动各个设备
    public void checkWakeUpTime() {
        LocalTime now = LocalTime.now(); // 获取当前时间
        if (now.equals(wakeUpTime) || now.isAfter(wakeUpTime)) { // 检查当前时间是否等于或晚于起床时间
            tempController.startAdjusting(); // 启动温度调节器
            lightController.startAdjusting(); // 启动光线调节器
            speaker.startPlaying(); // 启动智能音箱
            bed.startMassaging(); // 启动按摩床
        }
    }

    // 起床系统方法：创建图形界面，使用Swing组件布局各个区域和控件
    public void createGUI() {
        JFrame frame = new JFrame("张少爷起床系统"); // 创建一个窗口对象，并设置标题
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作为退出程序
        frame.setSize(800, 600); // 设置窗口的大小为800*600像素

        JLabel titleLabel = new JLabel("张少爷起床系统", SwingConstants.CENTER); // 创建一个标签对象，并设置文本和对齐方式
        titleLabel.setFont(new Font("宋体", Font.BOLD, 36)); // 设置标签的字体、样式和大小
        titleLabel.setForeground(Color.BLUE); // 设置标签的前景色为蓝色

        JLabel wakeUpTimeLabel = new JLabel(wakeUpTime.toString(), SwingConstants.CENTER); // 创建一个标签对象，并设置文本和对齐方式
        wakeUpTimeLabel.setFont(new Font("宋体", Font.PLAIN, 24)); // 设置标签的字体、样式和大小
        wakeUpTimeLabel.setForeground(Color.BLUE); // 设置标签的前景色为蓝色

        JLabel countdownLabel = new JLabel("", SwingConstants.CENTER); // 创建一个标签对象，并设置文本和对齐方式
        countdownLabel.setFont(new Font("宋体", Font.PLAIN, 24)); // 设置标签的字体、样式和大小
        countdownLabel.setForeground(Color.RED); // 设置标签的前景色为红色

        JPanel panel1 = new JPanel(); // 创建一个面板对象，用于放置第1个区域的控件
        panel1.setBorder(BorderFactory.createTitledBorder("设置起床时间")); // 设置面板的边框和标题

        JTextField timeField = new JTextField(10); // 创建一个文本框对象，并设置列数为10
                JButton setTimeButton = new JButton("设置"); // 创建一个按钮对象，并设置文本
        setTimeButton.addActionListener(new ActionListener() { // 为按钮添加动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 当按钮被点击时执行的方法
                String time = timeField.getText(); // 获取文本框中的文本
                try {
                    setWakeUpTime(time); // 调用起床系统的方法，设置起床时间
                    wakeUpTimeLabel.setText(wakeUpTime.toString()); // 更新起床时间标签的文本
                    countdownLabel.setText(""); // 清空倒计时标签的文本
                } catch (Exception ex) { // 捕获可能发生的异常
                    JOptionPane.showMessageDialog(frame, "请输入正确的时间格式（HH:mm:ss）", "错误", JOptionPane.ERROR_MESSAGE); // 弹出错误提示框
                }
            }
        });

        panel1.add(timeField); // 将文本框添加到面板中
        panel1.add(setTimeButton); // 将按钮添加到面板中

        JPanel panel2 = new JPanel(); // 创建一个面板对象，用于放置第2个区域的控件
        panel2.setBorder(BorderFactory.createTitledBorder("显示用户的人体节律")); // 设置面板的边框和标题

        JTextField birthdayField = new JTextField(10); // 创建一个文本框对象，并设置列数为10
        JButton confirmButton = new JButton("确认"); // 创建一个按钮对象，并设置文本
        confirmButton.addActionListener(new ActionListener() { // 为按钮添加动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 当按钮被点击时执行的方法
                String birthday = birthdayField.getText(); // 获取文本框中的文本
                try {
                    setUser(birthday); // 调用起床系统的方法，设置用户
                    double emotion = user.getEmotion(); // 获取用户的情绪指数
                    double intelligence = user.getIntelligence(); // 获取用户的智力指数
                    double physical = user.getPhysical(); // 获取用户的体力指数
                    String message = String.format("情绪：%f，智力：%f，体力：%f", emotion, intelligence, physical); // 格式化输出信息
                    JOptionPane.showMessageDialog(frame, message, "人体节律", JOptionPane.INFORMATION_MESSAGE); // 弹出信息提示框
                    wakeUpTimeLabel.setText(wakeUpTime.toString()); // 更新起床时间标签的文本
                    countdownLabel.setText(""); // 清空倒计时标签的文本
                } catch (Exception ex) { // 捕获可能发生的异常
                    JOptionPane.showMessageDialog(frame, "请输入正确的生日格式（yyyy-MM-dd）", "错误", JOptionPane.ERROR_MESSAGE); // 弹出错误提示框
                }
            }
        });

        panel2.add(birthdayField); // 将文本框添加到面板中
        panel2.add(confirmButton); // 将按钮添加到面板中

        JPanel panel3 = new JPanel(); // 创建一个面板对象，用于放置第3个区域的控件
        panel3.setBorder(BorderFactory.createTitledBorder("温度调节器")); // 设置面板的边框和标题

        JLabel currentTempLabel = new JLabel(String.valueOf(tempController.getCurrentTemp())); // 创建一个标签对象，并设置文本为当前温度值
                JLabel targetTempLabel = new JLabel(String.valueOf(tempController.getTargetTemp())); // 创建一个标签对象，并设置文本为目标温度值
        JLabel adjustingLabel = new JLabel(tempController.isAdjusting() ? "正在调节温度" : ""); // 创建一个标签对象，并设置文本为是否正在调节温度

        JTextField tempField = new JTextField(10); // 创建一个文本框对象，并设置列数为10
        JButton setTempButton = new JButton("设置温度"); // 创建一个按钮对象，并设置文本
        setTempButton.addActionListener(new ActionListener() { // 为按钮添加动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 当按钮被点击时执行的方法
                String temp = tempField.getText(); // 获取文本框中的文本
                try {
                    int targetTemp = Integer.parseInt(temp); // 将字符串转换为整数
                    tempController.setTargetTemp(targetTemp); // 调用温度调节器的方法，设置目标温度
                    targetTempLabel.setText(String.valueOf(tempController.getTargetTemp())); // 更新目标温度标签的文本
                } catch (Exception ex) { // 捕获可能发生的异常
                    JOptionPane.showMessageDialog(frame, "请输入正确的温度值", "错误", JOptionPane.ERROR_MESSAGE); // 弹出错误提示框
                }
            }
        });

        panel3.add(currentTempLabel); // 将当前温度标签添加到面板中
        panel3.add(targetTempLabel); // 将目标温度标签添加到面板中
        panel3.add(adjustingLabel); // 将是否正在调节温度标签添加到面板中
        panel3.add(tempField); // 将文本框添加到面板中
        panel3.add(setTempButton); // 将按钮添加到面板中

        JPanel panel4 = new JPanel(); // 创建一个面板对象，用于放置第4个区域的控件
        panel4.setBorder(BorderFactory.createTitledBorder("光线调节器")); // 设置面板的边框和标题

        JLabel currentLightLabel = new JLabel(String.valueOf(lightController.getCurrentLight()) + "级光线"); // 创建一个标签对象，并设置文本为当前光线值
        JLabel targetLightLabel = new JLabel(String.valueOf(lightController.getTargetLight()) + "级光线"); // 创建一个标签对象，并设置文本为目标光线值
        JLabel adjustingLightLabel = new JLabel(lightController.isAdjusting() ? "正在调节光线：" : ""); // 创建一个标签对象，并设置文本为是否正在调节光线

        JTextField lightField = new JTextField(10); // 创建一个文本框对象，并设置列数为10
        JButton setLightButton = new JButton("设置光线"); // 创建一个按钮对象，并设置文本
        setLightButton.addActionListener(new ActionListener() { // 为按钮添加动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 当按钮被点击时执行的方法
                String light = lightField.getText(); // 获取文本框中的文本
                try {
                    int targetLight = Integer.parseInt(light); // 将字符串转换为整数
                    lightController.setTargetLight(targetLight); // 调用光线调节器的方法，设置目标光线
                    targetLightLabel.setText(String.valueOf(lightController.getTargetLight()) + "级光线"); // 更新目标光线标签的文本
                } catch (Exception ex) { // 捕获可能发生的异常
                    JOptionPane.showMessageDialog(frame, "请输入正确的光线值", "错误", JOptionPane.ERROR_MESSAGE); // 弹出错误提示框
                }
            }
        });

        panel4.add(currentLightLabel); // 将当前光线标签添加到面板中
                panel4.add(targetLightLabel); // 将目标光线标签添加到面板中
        panel4.add(adjustingLightLabel); // 将是否正在调节光线标签添加到面板中
        panel4.add(lightField); // 将文本框添加到面板中
        panel4.add(setLightButton); // 将按钮添加到面板中

        JPanel panel5 = new JPanel(); // 创建一个面板对象，用于放置第5个区域的控件
        panel5.setBorder(BorderFactory.createTitledBorder("智能音箱")); // 设置面板的边框和标题

        String[] musicList = {"青花瓷", "告白气球", "稻香", "夜曲"}; // 创建一个字符串数组，用于存放音乐列表
        JComboBox<String> musicBox = new JComboBox<>(musicList); // 创建一个下拉框对象，并设置选项为音乐列表
        musicBox.addActionListener(new ActionListener() { // 为下拉框添加动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 当下拉框被选择时执行的方法
                String music = (String) musicBox.getSelectedItem(); // 获取下拉框中选择的音乐
                speaker.setMusic(music); // 调用智能音箱的方法，设置播放的音乐
            }
        });

        JLabel playingLabel = new JLabel(speaker.isPlaying() ? "正在播放中" : "智能音箱播放状态"); // 创建一个标签对象，并设置文本为是否正在播放音乐

        panel5.add(musicBox); // 将下拉框添加到面板中
        panel5.add(playingLabel); // 将是否正在播放音乐标签添加到面板中

        JPanel panel6 = new JPanel(); // 创建一个面板对象，用于放置第6个区域的控件
                panel6.setBorder(BorderFactory.createTitledBorder("按摩床状态")); // 设置面板的边框和标题

        JLabel massagingLabel = new JLabel(bed.isMassaging() ? "已启动" : "未启动"); // 创建一个标签对象，并设置文本为是否正在按摩
        massagingLabel.setForeground(bed.isMassaging() ? Color.RED : Color.BLACK); // 设置标签的前景色为是否正在按摩

        JLabel currentStrengthLabel = new JLabel(String.valueOf(bed.getCurrentStrength())); // 创建一个标签对象，并设置文本为当前按摩力度

        panel6.add(massagingLabel); // 将是否正在按摩标签添加到面板中
        panel6.add(currentStrengthLabel); // 将当前按摩力度标签添加到面板中

        JPanel mainPanel = new JPanel(); // 创建一个主面板对象，用于放置所有的区域面板
        mainPanel.setLayout(new GridLayout(3, 2)); // 设置主面板的布局为网格布局，3行2列
        mainPanel.add(panel1); // 将第1个区域面板添加到主面板中
        mainPanel.add(panel2); // 将第2个区域面板添加到主面板中
        mainPanel.add(panel3); // 将第3个区域面板添加到主面板中
        mainPanel.add(panel4); // 将第4个区域面板添加到主面板中
        mainPanel.add(panel5); // 将第5个区域面板添加到主面板中
        mainPanel.add(panel6); // 将第6个区域面板添加到主面板中

        frame.add(titleLabel, BorderLayout.NORTH); // 将标题标签添加到窗口的北部（上方）
        frame.add(wakeUpTimeLabel, BorderLayout.CENTER); // 将起床时间标签添加到窗口的中心
        frame.add(countdownLabel, BorderLayout.SOUTH); // 将倒计时标签添加到窗口的南部（下方）
        frame.add(mainPanel, BorderLayout.EAST); // 将主面板添加到窗口的东部（右方）

        frame.setVisible(true); // 设置窗口可见

        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() { // 创建一个定时器对象，并设置时间间隔为1000毫秒（1秒），以及动作监听器
            @Override
            public void actionPerformed(ActionEvent e) { // 每隔一秒执行的方法
                checkWakeUpTime(); // 调用起床系统的方法，检查是否到达起床时间
                updateGUI(); // 调用起床系统的方法，更新图形界面
            }
        });

        timer.start(); // 启动定时器
    }

    // 起床系统方法：更新图形界面，根据各个设备的状态更新对应的标签或控件
    public void updateGUI() {
        LocalTime now = LocalTime.now(); // 获取当前时间
        long seconds = now.until(wakeUpTime, java.time.temporal.ChronoUnit.SECONDS); // 计算当前时间到起床时间的秒数
        if (seconds > 0) { // 如果还未到达起床时间
            long hours = seconds / 3600; // 计算剩余的小时数
            long minutes = (seconds % 3600) / 60; // 计算剩余的分钟数
            long secs = seconds % 60; // 计算剩余的秒数
            String countdown = String.format("距离起床时间还有%02d:%02d:%02d", hours, minutes, secs); // 格式化输出倒计时信息
            countdownLabel.setText(countdown); // 更新倒计时标签的文本
        } else { // 如果已经到达或超过起床时间
            countdownLabel.setText(""); // 清空倒计时标签的文本
        }

        if (tempController.isAdjusting()) { // 如果温度调节器正在调节温度
            adjustingLabel.setText("正在调节温度"); // 更新是否正在调节温度标签的文本
            if (tempController.getCurrentTemp() < tempController.getTargetTemp()) { // 如果当前温度小于目标温度
                tempController.increaseCurrentTemp(); // 调用温度调节器的方法，增加当前温度
                currentTempLabel.setText(String.valueOf(tempController.getCurrentTemp())); // 更新当前温度标签的文本
            } else { // 如果当前温度大于等于目标温度
                tempController.stopAdjusting(); // 调用温度调节器的方法，停止调节温度
                adjustingLabel.setText(""); // 清空是否正在调节温度标签的文本
            }
        }

        if (lightController.isAdjusting()) { // 如果光线调节器正在调节光线
            adjustingLightLabel.setText("正在调节光线：" + lightController.getCurrentLight()); // 更新是否正在调节光线标签的文本，并显示当前光线值
            adjustingLightLabel.setForeground(Color.RED); // 设置是否正在调节光线标签的前景色为红色
            if (lightController.getCurrentLight() < lightController.getTargetLight()) { // 如果当前光线小于目标光线
                lightController.increaseCurrentLight(); // 调用光线调节器的方法，增加当前光线
                currentLightLabel.setText(lightController.getCurrentLight() + "级光线"); // 更新当前光线标签的文本，并显示当前光线值
            } else { // 如果当前光线大于等于目标光线
                lightController.stopAdjusting(); // 调用光线调节器的方法，停止调节光线
                adjustingLightLabel.setText(""); // 清空是否正在调节光线标签的文本
                adjustingLightLabel.setForeground(Color.BLACK); // 设置是否正在调节光线标签的前景色为黑色
            }
        }

        if (speaker.isPlaying()) { // 如果智能音箱正在播放音乐
            playingLabel.setText("正在播放中"); // 更新是否正在播放音乐标签的文本
            playingLabel.setForeground(Color.RED); // 设置是否正在播放音乐标签的前景色为红色
        }

        if (bed.isMassaging()) { // 如果按摩床正在按摩
            massagingLabel.setText("已启动"); // 更新是否正在按摩标签的文本
            massagingLabel.setForeground(Color.RED); // 设置是否正在按摩标签的前景色为红色
            bed.increaseCurrentStrength(); // 调用按摩床的方法，增加当前按摩力度
            currentStrengthLabel.setText(String.valueOf(bed.getCurrentStrength())); // 更新当前按摩力度标签的文本
        }
    }

    // 起床系统方法：主方法，创建起床系统对象，并调用创建图形界面的方法
    public static void main(String[] args) {
        WakeUpSystem system = new WakeUpSystem(); // 创建起床系统对象
        system.createGUI(); // 调用创建图形界面的方法
    }
}
