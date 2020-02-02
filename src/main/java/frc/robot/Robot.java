/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
//import sun.security.krb5.internal.AuthContext;
// import sun.security.jgss.spnego.SpNegoContext;

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
  //private static final int NeoShooter_ID = 1; 

  private static final int FalconShooter_ID = 1;

  //private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;
  private XboxController m_Controller = new XboxController(2);

  public static final int mPCM_B = 1;
  public static final int Popout = 1;
  public static final int Popin = 1;


  public Solenoid PopoutHoodPopout, PopoutHoodPopin;

  public static final int ShooterEXTENDED = 0;
  public static final int ShooterRETRACTED = 1;
  public static int Shooter_STATE = ShooterRETRACTED;



  //private SpeedController m_motor;
  private Joystick m_joystick;
  private CANSparkMax NeoShooter;

  public WPI_TalonFX FalconShooter;


  @Override
  public void robotInit() {
    //m_motor = new PWMVictorSPX(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
   // NeoShooter = new CANSparkMax(NeoShooter_ID, MotorType.kBrushless);

   FalconShooter = new WPI_TalonFX(FalconShooter_ID);
   PopoutHoodPopout = new Solenoid(mPCM_B, Popout);
   PopoutHoodPopin = new Solenoid(mPCM_B, Popin);


   // NeoShooter.restoreFactoryDefaults();




  }

  @Override
  public void teleopPeriodic() {
    //m_motor.set(m_joystick.getY());
    //NeoShooter.set(m_joystick.getY());
    boolean A = m_Controller.getAButton();
    boolean stop = m_Controller.getBButton();
    boolean X = m_Controller.getXButton();
    boolean Y = m_Controller.getYButton();
    boolean Start = m_Controller.getStartButton();
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
  

    if (Start && Shooter_STATE == ShooterRETRACTED){
      PopoutHoodPopout.set(true);
      PopoutHoodPopin.set(false);
      Shooter_STATE = ShooterEXTENDED;
    }
    if (Start && Shooter_STATE == ShooterEXTENDED){
      PopoutHoodPopout.set(false);
      PopoutHoodPopin.set(true);
      Shooter_STATE = ShooterEXTENDED;
    }
    if (Y){
      FalconShooter.set(1.0);
    }
    if(X){
      FalconShooter.set(0.75);
    }
    if (A){
      NeoShooter.set(0.5);
    }
     else{
      NeoShooter.set(0.0);
    } 

    if(stop){
      FalconShooter.set(0.0);
    } 
    //FalconShooter.set(m_joystick.getY());
    

  }
}
