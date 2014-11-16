package com.example.contents.ten.complexservice;

import com.example.contents.ten.complexservice.Person;
import com.example.contents.ten.complexservice.Pet;
interface IPet
{
	List<Pet> getPets(in Person owner);
}