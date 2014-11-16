package com.example.contents.ten.complexservice;
import java.util.List;

interface IPet
{
	List<Pet> getPets(in Person owner);
}