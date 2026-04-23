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
    public static final String ACCOUNT_SID = System.getenv("TWILIO_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH");
    public static final String from_number = "+12709006745";
    public String to_number = "";
    public Integer saveotp;

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Autowired
    public AppointmentRepo appointmentrepo;

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

    public long getcountbydate(String appdate, String doctor) {
        long count = appointmentrepo.countByAppointmentdateAndDoctor(appdate, doctor);
        return count;
    }

    public List<AppointmentEntity> showAllEnquires() {
        return appointmentrepo.findAll();
    }

    public void sendotp(String mnumber) {
        // Ensure the number is in E.164 format
        if (!mnumber.startsWith("+")) {
            mnumber = "+91" + mnumber;
        }

        System.out.println("Sending OTP to: " + mnumber);

        String messageBody = "You have an appointment on selected date with the doctor.";

        try {
            Message message = Message.creator(
                    new PhoneNumber(mnumber),
                    new PhoneNumber(from_number),
                    messageBody).create();

            System.out.println("Message sent: " + message.getSid());

        } catch (Exception e) {
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

}
