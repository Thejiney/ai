# Generated by Django 5.1.6 on 2025-02-20 11:22

import blog.models
from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="Post",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("title", models.CharField(max_length=100, verbose_name="제목")),
                ("content", models.TextField()),
                ("create_at", models.DateField(auto_now_add=True, verbose_name="본문")),
                ("update_at", models.DateTimeField(auto_now=True, verbose_name="지역")),
                (
                    "region",
                    models.CharField(
                        choices=[
                            ("Europe", "유럽"),
                            ("Asia", "아시아"),
                            ("Africa", "아프리카"),
                            ("Oceania", "오세아니아"),
                            ("America", "아메리카"),
                        ],
                        default="Asia",
                        max_length=20,
                    ),
                ),
                (
                    "lnglat",
                    models.CharField(
                        blank=True,
                        help_text="경도,위도 포맷",
                        max_length=100,
                        null=True,
                        validators=[blog.models.lnglat_validator],
                        verbose_name="경, 위도",
                    ),
                ),
                ("url", models.URLField(blank=True, null=True)),
            ],
            options={
                "ordering": ["-update_at"],
            },
        ),
    ]
