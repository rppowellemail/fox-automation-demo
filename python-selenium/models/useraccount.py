# -*- coding: utf-8 -*-

import datetime
import random

class UserAccount:

    __slots__ = [
        'firstname',
        'lastname',
        'email',
        'password',
        'gender',
        'birthdateMonth',
        'birthdateDay',
        'birthdateYear'
    ]

    def __init__(self, **kwargs):
        for key, value in kwargs.items():
            setattr(self, key, value)

    @staticmethod
    def generateDateString():
        """ yyyy-mm-dd'T'HH-mm-ss-rrrr """
        return datetime.datetime.utcnow().strftime('%Y-%m-%dT-%H-%M-%S-') + str(random.randint(1000,9999))

    @staticmethod
    def generateUserAccount(datetimestring):
        u = UserAccount(
            firstname='F-' + datetimestring,
            lastname='L-' + datetimestring,
            email= "email-" + datetimestring + "@test.com",
            password = "password-" + datetimestring,
            gender = "Male",
            birthdateMonth = "01",
            birthdateDay = "01",
            birthdateYear = "2000"
        )
        return u
