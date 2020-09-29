#Brennan Price
#Created 09/28/2020
#

#Imports
import RPi.GPIO as GPIO

###MAIN###
GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)
GPIO.output(18, GPIO.HIGH)
