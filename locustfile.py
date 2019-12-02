from locust import HttpLocust, TaskSet, task, between

import random


class UserBehavior(TaskSet):
    def on_start(self):
        """ on_start is called when a Locust start before any task is scheduled """
        self.create()

    def on_stop(self):
        """ on_stop is called when the TaskSet is stopping """

    @task(1)
    def create(self):
        self.client.post("/users", UserProvider.supply_user())


class WebsiteUser(HttpLocust):
    task_set = UserBehavior
    wait_time = between(5, 9)


class UserProvider:

    first_names = ['Edgardo', 'Evan', 'Myesha', 'Jacqui', 'Maple', 'Janel', 'Valeri', 'Zack', 'Alonzo', 'Carmine',
                   'Ocie', 'Hector', 'Maricela', 'Geraldo', 'Loura', 'Eneida', 'Cuc', 'Annett', 'Dedra', 'Suzie']

    last_names = ['Futch', 'Twilley', 'Langner', 'Grado', 'Seiter', 'Rieder', 'Rodrick', 'Lawrence', 'Kimbell',
                  'Snedeker', 'Patlan', 'Haar', 'Walko', 'Lindeman', 'Bushey', 'Hardisty', 'Harrel',  'Yeh', 'Lueck',
                  'Andry']

    states = ['AA', 'AE', 'AP', 'AL', 'AK', 'AS', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'DC', 'FM', 'FL', 'GA', 'GU',
              'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MH', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT',
              'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'MP', 'OH', 'OK', 'OR', 'PW', 'PA', 'PR', 'RI', 'SC',
              'SD', 'TN', 'TX', 'UT', 'VT', 'VI', 'VA', 'WA', 'WV', 'WI', 'WY']

    def supply_user(self):
        first_name = random.choice(self.first_names)
        last_name = random.choice(self.last_names)
        username = (first_name + '.' + last_name).lower()
        password = 'P@55w0Rd1'
        state = random.choice(self.states)
        age = random.randint(1, 100)
        return {"firstName": first_name, "lastName": last_name, "username": username, "password": password,
                "state": state, "age": age}
