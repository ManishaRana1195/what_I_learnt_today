#!usr/bin/python


def readable_timedelta(days):
    week_count = days // 7
    day_count = days % 7 
    return "{} week(s) and {} day(s).".format(week_count,day_count)
    
print(readable_timedelta(9))
print(readable_timedelta(6))
print(readable_timedelta(7))
print(readable_timedelta(6678))

