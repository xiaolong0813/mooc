# Enter a code
class Person(object):
    def __init__(self, name, gender):
        self.name = name
        self.gender = gender


class Teacher(Person):
    def __init__(self, name, gender, course):
        super(Teacher, self).__init__(name, gender)
        self.course = course


class SkillMixin(object):
    def __init__(self, skill_name):
        self.skill_name = skill_name

    def check_skill(self):
        print('I can play: ' + self.skill_name)


class BasketballMixin(SkillMixin):
    def __init__(self, skill_name='basketball'):
        super(BasketballMixin, self).__init__(skill_name)


class FootballMixin(SkillMixin):
    def __init__(self, skill_name='football'):
        super(FootballMixin, self).__init__(skill_name)


class TeacherCanFootball(Teacher, FootballMixin):
    def __init__(self, name, gender, course):
        Teacher.__init__(self, name, gender, course)
        FootballMixin.__init__(self)
        print('a teacher can play football')


she = TeacherCanFootball('Liu', 'man', 'math')
# print(TeacherCanFootball.__mro__)
# FootballMixin.check_skill(she)
she.check_skill()
print(she.__class__.__mro__)