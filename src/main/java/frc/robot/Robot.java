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

import edu.wpi.first.wpilibj.GenericHID.Hand;
//import sun.security.krb5.internal.AuthContext;

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

  //private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;
  private XboxController m_Controller = new XboxController(2);

  //private SpeedController m_motor;
  private Joystick m_joystick;
  private CANSparkMax NeoShooter;


  @Override
  public void robotInit() {
    //m_motor = new PWMVictorSPX(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
    NeoShooter = new CANSparkMax(NeoShooter_ID, MotorType.kBrushless);

    NeoShooter.restoreFactoryDefaults();


  }

  @Override
  public void teleopPeriodic() {
    //m_motor.set(m_joystick.getY());
    //NeoShooter.set(m_joystick.getY());
    boolean auto = m_Controller.getBButton();
    boolean stop = m_Controller.getAButton();

    if (auto){
      NeoShooter.set(1.0);
    }
    /* else{
      NeoShooter.set(0.0);
    } */
    if(stop){
      NeoShooter.set(0.0);
    }

  }
}
