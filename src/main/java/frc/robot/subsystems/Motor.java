package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
	private TalonFX motor = new TalonFX(0);

	public Motor() {
		TalonFXConfigurator talonFXConfigurator = motor.getConfigurator();

		// Current limit configuration
		CurrentLimitsConfigs limitConfigs = new CurrentLimitsConfigs();
		limitConfigs.SupplyCurrentLimit = 40.0;
		limitConfigs.SupplyCurrentLimitEnable = true;

		talonFXConfigurator.apply(limitConfigs);
	}

	public void setMotorSpeed(double speed) {
		motor.set(speed);
	}

	public Command setMotorSpeedCommand(Supplier<Double> speed) {
		return runOnce(() -> {
			setMotorSpeed(speed.get());
		});
	}
}
