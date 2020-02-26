/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
<<<<<<< Updated upstream
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
=======
//import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.WaitCommand;

//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import sun.security.krb5.internal.AuthContext;
// import sun.security.jgss.spnego.SpNegoContext;
>>>>>>> Stashed changes

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */

public class Robot extends TimedRobot {
  private static final int NeoShooter_ID = 1; 
<<<<<<< Updated upstream

  //private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;
=======

  //private static final int Intake_ID = 7;

  //private static final int FalconShooter_ID = 1;
  //private static final int pulleyMotor_ID = 10;
  //private static final int pulleyMotorBottom_ID = 8;

  /*     //controls 
      public static final boolean pulleyMotorStateSpinning = true;
      public static final boolean pulleyMotorStateStill = false;
      public static boolean pulleyMotorState = pulleyMotorStateStill;
  
      public static final boolean pulleyMotorTopStateSpinning = true;
      public static final boolean pulleyMotorTopStateStill = false;
      public static boolean pulleyMotorTopState = pulleyMotorTopStateStill;
   
      public static final boolean intakeMotorSpinning = true;
      public static final boolean intakeMotorStill = false;
      public static boolean intakeMotorState = intakeMotorStill;

      public static final boolean NeoShooterSpinning = true;
      public static final boolean NeoShooterStill = false;
      public static boolean NeoShooterState = NeoShooterStill;

      public static boolean XButton_toggle = false;
      public static boolean AButton_toggle = false;
      public static boolean BButton_toggle = false;
      public static boolean YButton_toggle = false; */
    

  //private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;
  private XboxController m_Controller = new XboxController(2);

  /* public static final int mPCM_B = 1;
  public static final int Popout = 1;
  public static final int Popin = 1; */


  //public Solenoid PopoutHoodPopout, PopoutHoodPopin;

  //public static final int ShooterEXTENDED = 0;
  //public static final int ShooterRETRACTED = 1;
  //public static int Shooter_STATE = ShooterRETRACTED;


>>>>>>> Stashed changes

  //private SpeedController m_motor;
  private Joystick m_joystick;
  private CANSparkMax NeoShooter;

<<<<<<< Updated upstream
=======
  public WPI_TalonFX FalconShooter;
  public WPI_TalonSRX Intake, pulleyMotor, pulleyMotorTop; 

  

>>>>>>> Stashed changes

  @Override
  public void robotInit() {
    //m_motor = new PWMVictorSPX(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
<<<<<<< Updated upstream
    NeoShooter = new CANSparkMax(NeoShooter_ID, MotorType.kBrushless);
=======
   NeoShooter = new CANSparkMax(NeoShooter_ID, MotorType.kBrushless);
/* 
   Intake = new WPI_TalonSRX(Intake_ID);
   pulleyMotor = new WPI_TalonSRX(pulleyMotor_ID);
   pulleyMotorTop = new WPI_TalonSRX(pulleyMotorBottom_ID); */

   //FalconShooter = new WPI_TalonFX(FalconShooter_ID);
   //PopoutHoodPopout = new Solenoid(mPCM_B, Popout);
   //PopoutHoodPopin = new Solenoid(mPCM_B, Popin);


   NeoShooter.restoreFactoryDefaults();


>>>>>>> Stashed changes

    NeoShooter.restoreFactoryDefaults();

  }

  @Override
  public void teleopPeriodic() {
    //m_motor.set(m_joystick.getY());
<<<<<<< Updated upstream
    NeoShooter.set(m_joystick.getY());
=======
    //NeoShooter.set(m_joystick.getY());

    

    boolean A = m_Controller.getAButton();
    boolean B = m_Controller.getBButton();
    boolean X = m_Controller.getXButton();
    boolean Y = m_Controller.getYButton();
    //boolean Start = m_Controller.getStartButton();
/* 
    public void ExtendTray() {
      mTray_Extend.set(Constants.On);
      mTray_Retract.set(Constants.Off);
      Constants.TRAY_STATE = Constants.TRAY_STATE_EXTENDED;
  }
  public void RetractTray() {
      mTray_Extend.set(Constants.Off);
      mTray_Retract.set(Constants.On);
      Constants.TRAY_STATE = Constants.TRAY_STATE_RETRACTED; 
      */
  

/*     if (Start && Shooter_STATE == ShooterRETRACTED){
      PopoutHoodPopout.set(true);
      PopoutHoodPopin.set(false);
      Shooter_STATE = ShooterEXTENDED;
    }
    if (Start && Shooter_STATE == ShooterEXTENDED){
      PopoutHoodPopout.set(false);
      PopoutHoodPopin.set(true);
      Shooter_STATE = ShooterEXTENDED;
    } */
/*     if (Y){
      FalconShooter.set(1.0);
    }
    if(X){
      FalconShooter.set(0.75);
    } */
/*       if (B && pulleyMotorState == pulleyMotorStateStill){
      //NeoShooter.set(0.1);
      //Intake.set(-0.8);
      pulleyMotor.set(0.5);
      //pulleyMotorTop.set(0.5);
      pulleyMotorState = pulleyMotorStateSpinning;
      
    }  
      else if (B && pulleyMotorState == pulleyMotorTopStateSpinning){

      pulleyMotor.set(0.0);
      pulleyMotorState = pulleyMotorStateStill;

      } */

 /*    if (A && pulleyMotorTopState == pulleyMotorTopStateStill){
      pulleyMotorTop.set(0.7);
      pulleyMotorTopState = pulleyMotorTopStateSpinning;
    }
     else if(A && pulleyMotorTopState == pulleyMotorTopStateSpinning){
      //NeoShooter.set(0.0);
      //Intake.set(0.0);
      //pulleyMotor.set(0.0);
      pulleyMotorTop.set(0.0);
      pulleyMotorTopState = pulleyMotorTopStateStill;
      }  

    if (X && intakeMotorState == intakeMotorStill){
      Intake.set(0.8);
      intakeMotorState = intakeMotorSpinning;
    }
      else if(X && intakeMotorState == intakeMotorSpinning){
      Intake.set(0.0);
      intakeMotorState = intakeMotorStill;
      } */



    /* if (Y && i){
      pulle yMotor.set(0.5);
    } */
   /*  if (Y && NeoShooterState == NeoShooterStill){
      NeoShooter.set(-0.5);
      NeoShooterState = NeoShooterSpinning;
    }
      else if (Y && NeoShooterState == NeoShooterSpinning){
      NeoShooter.set(0.0);
      NeoShooterState = NeoShooterStill;
      } */
    //Intake.set(m_joystick.getY());

    //FalconShooter.set(m_joystick.getY());

     if (A){
      NeoShooter.set(-0.8);
    }
    if (B){
      NeoShooter.set(0.0);
    }
 
    

>>>>>>> Stashed changes
  }
}
