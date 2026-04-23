package com.jjmcoe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class AppointmentService {

    public long maxpatient = 3;

    // ✅ Environment variables (secure)
    public static final String ACCOUNT_SID = System.getenv("TWILIO_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH");

    public static final String FROM_NUMBER = "+12709006745";

    @Autowired
    public AppointmentRepo appointmentrepo;

    // ✅ Save appointment
    public void saveappointmenttodb(AppointmentModel appointmentmodel) {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setFullname(appointmentmodel.getFullname());
        appointment.setAge(appointmentmodel.getAge());
        appointment.setGender(appointmentmodel.getGender());
        appointment.setMobilenumber(appointmentmodel.getMobilenumber());
        appointment.setAppointmentdate(appointmentmodel.getAppointmentdate());
        appointment.setDoctor(appointmentmodel.getDoctor());
        appointmentrepo.save(appointment);
    }

    // ✅ Count appointments
    public long getcountbydate(String appdate, String doctor) {
        return appointmentrepo.countByAppointmentdateAndDoctor(appdate, doctor);
    }

    // ✅ Fetch all
    public List<AppointmentEntity> showAllEnquires() {
        return appointmentrepo.findAll();
    }

    // ✅ Send OTP (SAFE + NO CRASH)
    public void sendotp(String mnumber) {

        // 🔴 Check credentials first
        if (ACCOUNT_SID == null || AUTH_TOKEN == null) {
            System.out.println("⚠ Twilio credentials not set. OTP not sent.");
            return;
        }

        // Initialize Twilio only when needed
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Format number
        if (!mnumber.startsWith("+")) {
            mnumber = "+91" + mnumber;
        }

        String messageBody = "You have an appointment on selected date with the doctor.";

        try {
            Message message = Message.creator(
                    new PhoneNumber(mnumber),
                    new PhoneNumber(FROM_NUMBER),
                    messageBody).create();

            System.out.println("✅ Message sent: " + message.getSid());

        } catch (Exception e) {
            System.err.println("❌ Failed to send message: " + e.getMessage());
        }
    }
}