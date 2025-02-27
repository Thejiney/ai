from django.shortcuts import render
from django.views.generic import ListView
from .models import Article

# Create your views here.
article_list = ListView.as_view(model=Article)