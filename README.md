This application finds all available time slots for a meeting with a specified duration for two calendars with different working hours and planned meetings.
Calendars are input via POST method in JSON format.
The application has been developed using Spring Boot, and comes with a JUnit test.
Assumptions: all input times are of string type with HH:MM format, and the duration is an integer of minutes.

Example:
{
"calendar_1": {
"working_hours": {
"start": "09:00",
"end": "19:55"
},
"planned_meeting": [
{
"start": "09:00",
"end": "10:30"
},
{
"start": "12:00",
"end": "13:00"
},
{
"start": "16:00",
"end": "18:00"
}
]
},
"calendar_2": {
"working_hours": {
"start": "10:00",
"end": "18:30"
},
"planned_meeting": [
{
"start": "10:00",
"end": "11:30"
},
{
"start": "12:30",
"end": "14:30"
},
{
"start": "14:30",
"end": "15:00"
},
{
"start": "16:00",
"end": "17:00"
}
]
}
}

Meeting duration: 30 minutes

Output:
{
"results": [
[
"11:30",
"12:00"
],
[
"15:00",
"16:00"
],
[
"18:00",
"18:30"
]
]
}